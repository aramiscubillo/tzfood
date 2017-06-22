/**
 * 
 */
package ts.tzfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ts.tzfood.jsonModels.ProductoJsonModel;
import ts.tzfood.mappers.ProductoMapper;
import ts.tzfood.services.ProductoServiceInterface;

/**
 * @author Aramis
 *
 */
@Controller
public class ProductoController {

	private ProductoMapper mapper = new ProductoMapper();
	
	@Autowired
	private ProductoServiceInterface productoService;
	
	@RequestMapping(value = "producto/getByMarca", method = RequestMethod.GET)
    public @ResponseBody List<String> getNombresPorMarca( @RequestParam(value = "marca", required = true) String marca) {
       
		return productoService.getNombreProductosPorMarca(marca);
    }
	
	@RequestMapping(value = "producto/getByNombre", method = RequestMethod.GET)
    public @ResponseBody List<ProductoJsonModel> getNombresPorNombre( 
    		@RequestParam(value = "nombre", required = true) String nombre,
    		@RequestParam(value = "marca", required = true) String marca) {
       
		return mapper.mapToJsonModel(productoService.getProductosPorNombre(nombre, marca));
    }
	
}
