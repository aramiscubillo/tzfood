/**
 * 
 */
package ts.tzfood.services;

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
	
}
