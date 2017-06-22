/**
 * 
 */
package ts.tzfood.dataLoader;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ts.tzfood.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepo;
     

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
	   
		/*
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
	    usuario.setEncryptedPassword(strongEncryptor.encryptPassword("eso12345"));
	    usuario.setUsername("Doc");
	    usuarioRepo.save(usuario);
	    
	    Producto producto = new Producto();
	    producto.setActivo(true);
	    producto.setNombre("Weight Managament");
	    producto.setFechaCreacion(new Date());
	    producto.setMarca("Super Guato");
	    producto.setPrecio(1000);
	    producto.setPresentacion("5 kg");
	    productoRepo.save(producto);
	    
	    producto = new Producto();
	    producto.setActivo(true);
	    producto.setNombre("Weight Managament");
	    producto.setFechaCreacion(new Date());
	    producto.setMarca("Super Guato");
	    producto.setPrecio(10000);
	    producto.setPresentacion("10 kg");
	    productoRepo.save(producto);
	    
	    producto = new Producto();
	    producto.setActivo(true);
	    producto.setNombre("Weight Managament");
	    producto.setFechaCreacion(new Date());
	    producto.setMarca("Super Guato");
	    producto.setPrecio(15000);
	    producto.setPresentacion("20 kg");
	    productoRepo.save(producto);
	    
	    
	    producto = new Producto();
	    producto.setActivo(true);
	    producto.setNombre("Pate");
	    producto.setFechaCreacion(new Date());
	    producto.setMarca("Saprissa");
	    producto.setPrecio(15000);
	    producto.setPresentacion("8 kg");
	    productoRepo.save(producto);
	    
	    producto = new Producto();
	    producto.setActivo(true);
	    producto.setNombre("Carvajal");
	    producto.setFechaCreacion(new Date());
	    producto.setMarca("Saprissa");
	    producto.setPrecio(1000);
	    producto.setPresentacion("8 kg");
	    productoRepo.save(producto);
	    */
		
		
	}
	
}
