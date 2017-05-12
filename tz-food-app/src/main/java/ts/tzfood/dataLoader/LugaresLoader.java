/**
 * 
 */
package ts.tzfood.dataLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ts.tzfood.constants.GeneralConstants;
import ts.tzfood.domain.Lugar;
import ts.tzfood.repositories.LugarRepository;

/**
 * @author Aramis
 *
 */
@Component
public class LugaresLoader implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private LugarRepository lugarRepo;
	
	 
     

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
	
	    Lugar provincia = new Lugar();
	    provincia.setNombre("San José");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Lugar();
	    provincia.setNombre("Alajuela");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Lugar();
	    provincia.setNombre("Heredia");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Lugar();
	    provincia.setNombre("Cartago");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Lugar();
	    provincia.setNombre("Puntarenas");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Lugar();
	    provincia.setNombre("Limón");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Lugar();
	    provincia.setNombre("Guanacaste");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	}
	
}
