/**
 * 
 */
package ts.tzfood.services;

import org.springframework.beans.factory.annotation.Autowired;

import ts.tzfood.domain.Lugar;
import ts.tzfood.repositories.LugarRepository;

/**
 * @author Aramis
 *
 */
public class LugarService implements LugarServiceInterface{

	@Autowired
	private LugarRepository lugarRepo;
	
	/* (non-Javadoc)
	 * @see ts.tzfood.services.LugarServiceInterface#listLugar()
	 */
	@Override
	public Iterable<Lugar> listLugar() {
		return lugarRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.LugarServiceInterface#getLugar(int)
	 */
	@Override
	public Lugar getLugar(int id) {
		return lugarRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.LugarServiceInterface#saveLugar(ts.tzfood.domain.Lugar)
	 */
	@Override
	public Lugar saveLugar(Lugar lugar) {
		return lugarRepo.save(lugar);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.LugarServiceInterface#deleteLugar(int)
	 */
	@Override
	public void deleteLugar(int id) {
		lugarRepo.delete(id);
	}

}
