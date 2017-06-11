/**
 * 
 */
package ts.tzfood.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import ts.tzfood.constants.GeneralConstants;
import ts.tzfood.domain.DetallePedido;
import ts.tzfood.domain.Pedido;
import ts.tzfood.domain.Producto;
import ts.tzfood.email.EmailTemplateUtils;
import ts.tzfood.jsonModels.ProductoJsonModel;
import ts.tzfood.models.PedidoModel;
import ts.tzfood.models.PedidoSearchModel;
import ts.tzfood.services.DetallePedidoServiceInterface;
import ts.tzfood.services.PedidoServiceInterface;
import ts.tzfood.services.ProductoServiceInterface;
import ts.tzfood.utils.Pager;

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
	
	@Autowired
	private EmailTemplateUtils sender;
	
	
	private static final int[] PAGE_SIZES = {3, 5, 10, 20, 50, 100 };
	private static final String[] BOLEANOS = {"", "Si", "No" };
	

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
    	pedido.setListoParaEntrega(false);
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
    		detalle.setProducto(producto);
    		pedido.getDetalles().add(detalle);
    		
    		detallePedidoService.savePedido(detalle);
    	}

    	String urlDetails = "http://localhost:8080/pedido/"+pedido.getId()+"/"+pedido.getToken();
    	sender.emailPedidoHecho(pedido.getId(), urlDetails,
    			pedido.getEmail(), pedido.getNombrePersona());
    	
        return "redirect:/pedido/" +pedido.getId()+"/"+pedido.getToken();
    }
    
    
    @RequestMapping("pedido/{id}/{token}")
    public String details(@PathVariable int id, @PathVariable String token,  Model model){
        
    	Pedido pedido = pedidoService.getPedido(id);
    	
    	if(pedido.getToken().equals(token)){
    		model.addAttribute("pedido", pedido);
            return "views/pedido/pedidoDetails";
    	}else{
    		 return "redirect:/";
    	}
   
    }
    
    @Secured({GeneralConstants.ROL_ADMIN})
    @RequestMapping(value = "pedido/pagar", method = RequestMethod.GET)
    public @ResponseBody String getNombresPorNombre( @RequestParam(value = "id", required = true) int id) {
       
    	Pedido pedido = pedidoService.getPedido(id);
    	pedido.setPagado(true);
    	pedidoService.savePedido(pedido);
    	
    	 return "200";
    }
    
    @Secured({GeneralConstants.ROL_ADMIN})
    @RequestMapping(value = "/pedidos", method = RequestMethod.GET)
    public String list(Model model){
        
    	PedidoSearchModel search = new PedidoSearchModel();
    	search.setNewSearch("old");
    	search.setPageSize(3);
    	search.setPageNumber(0);
    	Page<Pedido> pedidos;
    	
    	pedidos = pedidoService.find(search);
    	//5 = buttons to show
    	Pager pager = new Pager(pedidos.getTotalPages(), pedidos.getNumber(), 5);
    	search.setPedidos(pedidos);
    	search.setPager(pager);
    	model.addAttribute("search", search);
    	model.addAttribute("pageSizes", PAGE_SIZES);
    	model.addAttribute("boleanos", BOLEANOS);
    	
    	return "views/pedido/pedidosList";
    }
    
    
    @RequestMapping(value = "/pedidos", method = RequestMethod.POST)
    public String listPost(PedidoSearchModel search, Model model){
    	
    	Page<Pedido> pedidos;
    	
    	if(search.getNewSearch().equals("new")){
    		search.setPageNumber(0);
    	}
    	
    	pedidos = pedidoService.find(search);
    	//5 = buttons to show
    	Pager pager = new Pager(pedidos.getTotalPages(), pedidos.getNumber(), 5);
    	search.setPedidos(pedidos);
    	search.setPager(pager);
    	model.addAttribute("search", search);
    	model.addAttribute("pageSizes", PAGE_SIZES);
    	model.addAttribute("boleanos", BOLEANOS);
    	
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
