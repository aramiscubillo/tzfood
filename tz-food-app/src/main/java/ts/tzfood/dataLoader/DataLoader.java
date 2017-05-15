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
import ts.tzfood.domain.Producto;
import ts.tzfood.domain.Ubicacion;
import ts.tzfood.domain.Usuario;
import ts.tzfood.repositories.ProductoRepository;
import ts.tzfood.repositories.UbicacionRepository;
import ts.tzfood.repositories.UsuarioRepository;

/**
 * @author Aramis
 *
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private UbicacionRepository lugarRepo;
	
	@Autowired
	private StrongPasswordEncryptor strongEncryptor;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private ProductoRepository productoRepo;
     

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
	
	    Ubicacion provincia = new Ubicacion();
	    provincia.setNombre("San José");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Ubicacion();
	    provincia.setNombre("Alajuela");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Ubicacion();
	    provincia.setNombre("Heredia");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Ubicacion();
	    provincia.setNombre("Cartago");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Ubicacion();
	    provincia.setNombre("Puntarenas");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Ubicacion();
	    provincia.setNombre("Limón");
	    provincia.setTipo(GeneralConstants.PROVINCIA);
	    lugarRepo.save(provincia);
	    
	    provincia = new Ubicacion();
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
	    
	    usuario = new Usuario();
	    usuario.setActivo(true);
	    usuario.setEnabled(true);
	    usuario.setFechaCreacion(new Date());
	    usuario.setRol(GeneralConstants.ROL_ADMIN);
	    usuario.setEncryptedPassword(strongEncryptor.encryptPassword("abc123456"));
	    usuario.setUsername("mop1");
	    usuarioRepo.save(usuario);
	    
	    Producto producto = new Producto();
	    producto.setActivo(true);
	    producto.setEstilo("Weight Managament");
	    producto.setFechaCreacion(new Date());
	    producto.setMarca("Super Guato");
	    producto.setNombre("A1");
	    producto.setPrecio(5000);
	    producto.setPresentacion("Perro grandes");
	    
	    producto = new Producto();
	    producto.setActivo(true);
	    producto.setEstilo("Weight Managament");
	    producto.setFechaCreacion(new Date());
	    producto.setMarca("Super Guato");
	    producto.setNombre("A2");
	    producto.setPrecio(5000);
	    producto.setPresentacion("Perro pequeños");
	}
	
}
