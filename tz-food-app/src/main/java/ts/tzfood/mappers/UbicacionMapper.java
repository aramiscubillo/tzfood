/**
 * 
 */
package ts.tzfood.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import ts.tzfood.domain.Ubicacion;
import ts.tzfood.jsonModels.ProductoJsonModel;
import ts.tzfood.jsonModels.UbicacionJsonModel;

/**
 * @author Aramis
 *
 */
@Component
public class UbicacionMapper implements Mapper<Ubicacion,UbicacionJsonModel>{

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToJsonModel(java.lang.Object)
	 */
	@Override
	public UbicacionJsonModel mapToJsonModel(Ubicacion object) {
		
		UbicacionJsonModel model = new UbicacionJsonModel();
		model.setId(object.getId());
		model.setNombre(object.getNombre());
		model.setRegionPapa(object.getRegionPapa());
		
		return model;
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToObject(java.lang.Object)
	 */
	@Override
	public Ubicacion mapToObject(UbicacionJsonModel model) {
		Ubicacion ubicacion = new Ubicacion();
		
		ubicacion.setId(model.getId());
		ubicacion.setActivo(true);
		ubicacion.setFechaCreacion(new Date());
		ubicacion.setFechaEdicion(new Date());
		ubicacion.setNombre(model.getNombre());
		
		return ubicacion;
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToJsonModel(java.util.List)
	 */
	@Override
	public List<UbicacionJsonModel> mapToJsonModel(List<Ubicacion> objects) {

		 List<UbicacionJsonModel> models = new ArrayList<UbicacionJsonModel>();
		 
		objects.forEach(ubicacion ->{
			models.add(mapToJsonModel(ubicacion) );
		});
		
		return models;
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToObject(java.util.List)
	 */
	@Override
	public List<Ubicacion> mapToObject(List<UbicacionJsonModel> models) {
		
		List<Ubicacion> objects = new ArrayList<Ubicacion>();
		 
		models.forEach(json ->{
			objects.add(mapToObject(json) );
		});
		
		return objects;
	}

}
