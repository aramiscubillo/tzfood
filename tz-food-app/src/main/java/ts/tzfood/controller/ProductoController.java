/**
 * 
 */
package ts.tzfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ts.tzfood.domain.Pedido;
import ts.tzfood.domain.Producto;
import ts.tzfood.services.ProductoServiceInterface;

/**
 * @author Aramis
 *
 */
@Controller
public class ProductoController {

	@Autowired
	private ProductoServiceInterface productoService;
	
	
	@RequestMapping("producto/nuevo")
	public String newPedido(Model model){
	    model.addAttribute("producto", new Producto());
	    return "productoForm";
	}
	    
    @RequestMapping(value = "producto/nuevo", method = RequestMethod.POST)
    public String save(Producto pedido){
    	productoService.saveProducto(pedido);
        return "redirect:/pedido/" + pedido.getId();
    }
	    
	    
	    @RequestMapping("producto/{id}")
	    public String details(@PathVariable int id, Model model){
	        model.addAttribute("producto", productoService.getProducto(id));
	        return "showProducto";
	    }
	    
	    @RequestMapping(value = "/productos", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("productos", productoService.listProducto());
	        return "productos";
	    }
	    
	    @RequestMapping("productos/editar/{id}")
	    public String edit(@PathVariable int id, Model model){
	        model.addAttribute("product", productoService.getProducto(id));
	        return "pedidoForm";
	    }
	    
	    
	    @RequestMapping(value = "producto", method = RequestMethod.POST)
	    public String saveEdit(Producto producto){

	    	productoService.saveProducto(producto);
	        return "redirect:/producto/" + producto.getId();
	    }
	    
	    
	    @RequestMapping("producto/eliminar/{id}/{token}")
	    public String delete(@PathVariable int id, @PathVariable String tocken){
	    	productoService.deleteProducto(id);
	        return "redirect:/productos";
	    }
	
}
