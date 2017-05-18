/**
 * 
 */
package ts.tzfood.controller;

import java.util.Date;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import ts.tzfood.constants.GeneralConstants;
import ts.tzfood.domain.DetallePedido;
import ts.tzfood.domain.Pedido;
import ts.tzfood.domain.Producto;
import ts.tzfood.jsonModels.ProductoJsonModel;
import ts.tzfood.models.PedidoModel;
import ts.tzfood.services.DetallePedidoServiceInterface;
import ts.tzfood.services.PedidoServiceInterface;
import ts.tzfood.services.ProductoServiceInterface;

/**
 * @author Aramis
 *
 */
@Controller
public class PedidoController {
	
	@Autowired
	private PedidoServiceInterface pedidoService;
	
	@Autowired 
	private ProductoServiceInterface productoService;
	
	@Autowired
	private DetallePedidoServiceInterface detallePedidoService;

    @RequestMapping("pedido/nuevo")
    public String newPedido(Model model){
        model.addAttribute("model", new PedidoModel());
        model.addAttribute("marcas", GeneralConstants.MARCAS);
        return "views/pedido/pedidoForm";
    }
    
    @RequestMapping(value = "pedido/nuevo", method = RequestMethod.POST)
    public String save(PedidoModel model) throws Exception{
    	
    	
    	Pedido pedido = model.getPedido();
    	pedido.setActivo(true);
    	pedido.setFechaCreacion(new Date());
    	pedido.setPagado(false);
    	pedido.setToken(new Date().getTime()+"");
    	
    	pedidoService.savePedido(pedido);
    	
    	String products = model.getProductosList();
    	products = java.net.URLDecoder.decode(products, "UTF-8");
    	ObjectMapper mapper = new ObjectMapper();
    	ProductoJsonModel[] jsonObjects = mapper.readValue(products, ProductoJsonModel[].class);

    	DetallePedido detalle;
    	Producto producto;
    	for(int i=0; i< jsonObjects.length; i++){
    		detalle = new DetallePedido();
    		producto = productoService.getProducto(jsonObjects[i].getId());

    		detalle.setActivo(true);
    		detalle.setCantidad(jsonObjects[i].getCantidad());
    		detalle.setFechaCreacion(new Date());
    		detalle.setPedido(pedido);
    		detalle.setPrecio(producto.getPrecio());
    		pedido.getDetalles().add(detalle);
    		
    		detallePedidoService.savePedido(detalle);
    	}

        return "redirect:/pedido/" +pedido.getId();
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
