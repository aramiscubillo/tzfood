/**
 * 
 */
package ts.tzfood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ts.tzfood.domain.Producto;
import ts.tzfood.domain.Usuario;
import ts.tzfood.repositories.UsuarioRepository;

/**
 * @author Aramis
 *
 */
@Service
@Profile("springdatajpa")
public class UsuarioService implements UsuarioServiceInterface{

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private EncryptionService encryptionService;
	
	/* (non-Javadoc)
	 * @see ts.tzfood.services.UsuarioServiceInterface#listAll()
	 */
	@Override
	public Iterable<Usuario> listAll() {
		return usuarioRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.UsuarioServiceInterface#getById(java.lang.Integer)
	 */
	@Override
	public Usuario getById(Integer id) {
		return usuarioRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.UsuarioServiceInterface#saveOrUpdate(ts.tzfood.domain.Usuario)
	 */
	@Override
	@Transactional
	public Usuario saveOrUpdate(Usuario usuario) {
		 if(usuario.getPassword() != null){
			 usuario.setEncryptedPassword(encryptionService.encryptString(usuario.getPassword()));
	        }
	        return usuarioRepo.save(usuario);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.UsuarioServiceInterface#delete(int)
	 */
	@Override
	public void delete(int id) {
		usuarioRepo.delete(id);
	}
	
	@Override
	public Usuario findByUserName(String username) {
	    return usuarioRepo.findByUsername(username);
	}

}
