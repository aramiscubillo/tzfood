/**
 * 
 */
package ts.tzfood.services;

import java.util.List;

import ts.tzfood.domain.Ubicacion;

/**
 * @author Aramis
 *
 */
public interface UbicacionServiceInterface {

	Iterable<Ubicacion> listLugar();
	
	Ubicacion getLugar(int id);
	
	Ubicacion saveLugar(Ubicacion lugar);
	
	void deleteLugar(int id);
	
	List<Ubicacion> getUbicacionByRegionPapa(int papa);
	
}
