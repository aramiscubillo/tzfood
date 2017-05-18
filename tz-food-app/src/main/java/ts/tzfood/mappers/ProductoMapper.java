/**
 * 
 */
package ts.tzfood.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import ts.tzfood.domain.Producto;
import ts.tzfood.jsonModels.ProductoJsonModel;

/**
 * @author Aramis
 *
 */
@Component
public class ProductoMapper implements Mapper<Producto,ProductoJsonModel>{

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToJsonModel(java.lang.Object)
	 */
	@Override
	public ProductoJsonModel mapToJsonModel(Producto object) {
		
		ProductoJsonModel model = new ProductoJsonModel();
		model.setId(object.getId());
		model.setCantidad(0);
		model.setEstilo(object.getEstilo());
		model.setMarca(object.getMarca());
		model.setNombre(object.getNombre());
		model.setPrecio(object.getPrecio());
		model.setPrecioTotal(0);
		model.setPresentacion(object.getPresentacion());
		
		return model;
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToObject(java.lang.Object)
	 */
	@Override
	public Producto mapToObject(ProductoJsonModel model) {
		Producto producto = new Producto();
		
		producto.setId(model.getId());
		producto.setActivo(true);
		producto.setFechaCreacion(new Date());
		producto.setFechaEdicion(new Date());
		producto.setMarca(model.getMarca());
		producto.setNombre(model.getNombre());
		producto.setPrecio(model.getPrecio());
		producto.setPresentacion(model.getPresentacion());
		
		return producto;
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToJsonModel(java.util.List)
	 */
	@Override
	public List<ProductoJsonModel> mapToJsonModel(List<Producto> objects) {

		 List<ProductoJsonModel> models = new ArrayList<ProductoJsonModel>();
		 
		objects.forEach(producto ->{
			models.add(mapToJsonModel(producto) );
		});
		
		return models;
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToObject(java.util.List)
	 */
	@Override
	public List<Producto> mapToObject(List<ProductoJsonModel> models) {
		
		List<Producto> objects = new ArrayList<Producto>();
		 
		models.forEach(json ->{
			objects.add(mapToObject(json) );
		});
		
		return objects;
	}

}
