/**
 * 
 */
package ts.tzfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ts.tzfood.constants.GeneralConstants;
import ts.tzfood.domain.Pedido;
import ts.tzfood.models.PedidoModel;
import ts.tzfood.services.PedidoServiceInterface;

/**
 * @author Aramis
 *
 */
@Controller
public class PedidoController {
	
	@Autowired
	private PedidoServiceInterface pedidoService;

    @RequestMapping("pedido/nuevo")
    public String newPedido(Model model){
        model.addAttribute("model", new PedidoModel());
        model.addAttribute("marcas", GeneralConstants.MARCAS);
        return "views/pedido/pedidoForm";
    }
    
    @RequestMapping(value = "pedido/nuevo", method = RequestMethod.POST)
    public String save(Pedido pedido){
    	pedidoService.savePedido(pedido);
        return "redirect:/pedido/" + pedido.getId();
    }
    
    
    @RequestMapping("pedido/{id}")
    public String details(@PathVariable int id, Model model){
        model.addAttribute("pedido", pedidoService.getPedido(id));
        return "views/pedido/pedidoDetails";
    }
    
    @Secured({GeneralConstants.ROL_ADMIN})
    @RequestMapping(value = "/pedidos", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("pedidos", pedidoService.listPedidos());
        return "views/pedido/pedidosList";
    }
    

    @RequestMapping("pedido/editar/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("pedido", pedidoService.getPedido(id));
        return "views/pedido/pedidoForm";
    }
    
    
    @RequestMapping(value = "pedido", method = RequestMethod.POST)
    public String saveEdit(Pedido pedido){

    	pedidoService.savePedido(pedido);
        return "redirect:/pedido/" + pedido.getId();
    }
    
    
    @RequestMapping("pedido/eliminar/{id}/{token}")
    public String delete(@PathVariable int id, @PathVariable String token){
    	pedidoService.deletePedido(id);
        return "redirect:/pedidos";
    }
	
}
