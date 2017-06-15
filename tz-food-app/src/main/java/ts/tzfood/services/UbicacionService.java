/**
 * 
 */
package ts.tzfood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ts.tzfood.domain.Ubicacion;
import ts.tzfood.repositories.UbicacionRepository;

/**
 * @author Aramis
 *
 */
@Service
public class UbicacionService implements UbicacionServiceInterface{

	@Autowired
	private UbicacionRepository lugarRepo;
	
	/* (non-Javadoc)
	 * @see ts.tzfood.services.LugarServiceInterface#listLugar()
	 */
	@Override
	public Iterable<Ubicacion> listLugar() {
		return lugarRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.LugarServiceInterface#getLugar(int)
	 */
	@Override
	public Ubicacion getLugar(int id) {
		return lugarRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.LugarServiceInterface#saveLugar(ts.tzfood.domain.Lugar)
	 */
	@Override
	public Ubicacion saveLugar(Ubicacion lugar) {
		return lugarRepo.save(lugar);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.LugarServiceInterface#deleteLugar(int)
	 */
	@Override
	public void deleteLugar(int id) {
		lugarRepo.delete(id);
	}

	@Override
	public List<Ubicacion> getUbicacionByRegionPapa(int papa) {
		List<Ubicacion> list= lugarRepo.findByRegionPapa(papa);
		
		
		return list;
	}

}
