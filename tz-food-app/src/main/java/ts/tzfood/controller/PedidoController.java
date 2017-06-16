/**
 * 
 */
package ts.tzfood.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import ts.tzfood.services.UbicacionServiceInterface;
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
	private UbicacionServiceInterface ubicacionService;
	
	@Autowired
	private DetallePedidoServiceInterface detallePedidoService;
	
	@Autowired
	private EmailTemplateUtils sender;
	

	
	
	private static final int[] PAGE_SIZES = {3, 5, 10, 20, 50, 100 };
	private static final String[] BOLEANOS = {"", "Si", "No" };
	

	@RequestMapping(value = {"/","pedido/nuevo"}, method = RequestMethod.GET)
    public String newPedido(Model model){
        model.addAttribute("model", new PedidoModel());
        model.addAttribute("marcas", GeneralConstants.MARCAS);
        model.addAttribute("provincias", ubicacionService.getUbicacionByRegionPapa(1));
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
    	
    	String provincia = ubicacionService.getLugar(Integer.parseInt(model.getPedido().getProvincia())).getNombre();
    	String canton = ubicacionService.getLugar(Integer.parseInt(model.getPedido().getCanton())).getNombre();
    	
    	pedido.setProvincia(provincia);
    	pedido.setCanton(canton);
    	
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
    
    //@Secured({GeneralConstants.ROL_ADMIN})
    @RequestMapping(value = "pedido/pagar", method = RequestMethod.GET)
    public @ResponseBody String marcasPago( @RequestParam(value = "id", required = true) int id) {
       
    	Pedido pedido = pedidoService.getPedido(id);
    	pedido.setPagado(true);
    	pedidoService.savePedido(pedido);
    	
    	 return "200";
    }
    
    @RequestMapping(value = "pedido/confirmar", method = RequestMethod.GET)
    public @ResponseBody String marcarConfirmado( @RequestParam(value = "id", required = true) int id) {
       
    	Pedido pedido = pedidoService.getPedido(id);
    	pedido.setListoParaEntrega(true);
    	pedidoService.savePedido(pedido);
    	
    	 return "200";
    }
    
    @RequestMapping(value = "pedido/eliminar", method = RequestMethod.GET)
    public @ResponseBody String eliminarAdmin( @RequestParam(value = "id", required = true) int id) {
       
    	Pedido pedido = pedidoService.getPedido(id);
    	pedido.setActivo(false);
    	pedidoService.savePedido(pedido);
    	
    	 return "200";
    }
    
    @RequestMapping(value = "pedido/entregar", method = RequestMethod.GET)
    public @ResponseBody String entregar( @RequestParam(value = "id", required = true) int id) {
       
    	Pedido pedido = pedidoService.getPedido(id);
    	pedido.setEntregado(true);
    	pedido.setPagado(true);
    	pedidoService.savePedido(pedido);
    	
    	 return "200";
    }
    
    //@Secured({GeneralConstants.ROL_ADMIN})
    @RequestMapping(value = "/pedidos/{type}", method = RequestMethod.GET)
    public String list(@PathVariable String type, Model model){
        
    	PedidoSearchModel search = new PedidoSearchModel();
    	search.setNewSearch("old");
    	search.setPageSize(3);
    	search.setPageNumber(0);
    	search.setViewType(type);
    	Page<Pedido> pedidos;
    	
    	if(type.equals("entrega")){
    		search.setListoParaEntrega("Si");
    		search.setEntregado("No");
    	}
    	
    	
    	
    	pedidos = pedidoService.find(search);
    	//5 = buttons to show
    	Pager pager = new Pager(pedidos.getTotalPages(), pedidos.getNumber(), 5);
    	search.setPedidos(pedidos);
    	search.setPager(pager);
    	model.addAttribute("search", search);
    	model.addAttribute("pageSizes", PAGE_SIZES);
    	model.addAttribute("boleanos", BOLEANOS);
    	
    	return pedidosSearchViewHandler(type);
    }
    
    
    @RequestMapping(value = "/pedidos/{type}", method = RequestMethod.POST)
    public String listPost(PedidoSearchModel search, @PathVariable String type, Model model){
    	
    	Page<Pedido> pedidos;
    	
    	if(search.getNewSearch().equals("new")){
    		search.setPageNumber(0);
    	}
    	
    	if(type.equals("entrega")){
    		search.setListoParaEntrega("Si");
    		search.setEntregado("No");
    	}
    	
    	pedidos = pedidoService.find(search);
    	//5 = buttons to show
    	Pager pager = new Pager(pedidos.getTotalPages(), pedidos.getNumber(), 5);
    	search.setPedidos(pedidos);
    	search.setPager(pager);
    	model.addAttribute("search", search);
    	model.addAttribute("pageSizes", PAGE_SIZES);
    	model.addAttribute("boleanos", BOLEANOS);
    	
    	return pedidosSearchViewHandler(search.getViewType());
    }
    
     

    private String pedidosSearchViewHandler(String view){
    	if(view.equals("general")){
    		return "views/pedido/pedidosList";
    	}
    	
    	if(view.equals("entrega")){
    		return "views/pedido/pedidosPagadosList";
    	}
    	
    	return "";
    }
    
    //@Secured({GeneralConstants.ROL_ADMIN})
    @RequestMapping(value = "/pedidosPagados", method = RequestMethod.GET)
    public String listPagados(Model model){
        
    	PedidoSearchModel search = new PedidoSearchModel();
    	search.setNewSearch("old");
    	search.setPageSize(3);
    	search.setPageNumber(0);
    	search.setPagado("Si");
    	search.setEntregado("Si");
    	search.setListoParaEntrega("Si");
    	Page<Pedido> pedidos;
    	
    	pedidos = pedidoService.find(search);
    	//5 = buttons to show
    	Pager pager = new Pager(pedidos.getTotalPages(), pedidos.getNumber(), 5);
    	search.setPedidos(pedidos);
    	search.setPager(pager);
    	model.addAttribute("search", search);
    	model.addAttribute("pageSizes", PAGE_SIZES);
    	model.addAttribute("provincias", BOLEANOS);
    	
    	return "views/pedido/pedidosPagados";
    }
    
    
    @RequestMapping(value = "/pedidosPedidos", method = RequestMethod.POST)
    public String listPagadosPost(PedidoSearchModel search, Model model){
    	
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
    	model.addAttribute("provincias", BOLEANOS);
    	
    	return "views/pedido/pedidosPagados";
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
    public String deleteCliente(@PathVariable int id, @PathVariable String token){
    	pedidoService.deletePedido(id);
        return "redirect:/pedidos";
    }
	
}
