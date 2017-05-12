/**
 * 
 */
package ts.tzfood.services;

import ts.tzfood.domain.Lugar;

/**
 * @author Aramis
 *
 */
public interface LugarServiceInterface {

	Iterable<Lugar> listLugar();
	
	Lugar getLugar(int id);
	
	Lugar saveLugar(Lugar lugar);
	
	void deleteLugar(int id);
	
}
