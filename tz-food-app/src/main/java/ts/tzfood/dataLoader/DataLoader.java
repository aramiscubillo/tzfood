/**
 * 
 */
package ts.tzfood.dataLoader;

import java.util.Date;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ts.tzfood.constants.GeneralConstants;
import ts.tzfood.domain.Lugar;
import ts.tzfood.domain.Usuario;
import ts.tzfood.repositories.LugarRepository;
import ts.tzfood.repositories.UsuarioRepository;

/**
 * @author Aramis
 *
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private LugarRepository lugarRepo;
	
	@Autowired
	private StrongPasswordEncryptor strongEncryptor;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
     

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
	    
	    Usuario usuario = new Usuario();
	    usuario.setActivo(true);
	    usuario.setEnabled(true);
	    usuario.setFechaCreacion(new Date());
	    usuario.setRol(GeneralConstants.ROL_ADMIN);
	    usuario.setEncryptedPassword(strongEncryptor.encryptPassword("abc123456"));
	    usuario.setUsername("aramis");
	    usuarioRepo.save(usuario);
	}
	
}
