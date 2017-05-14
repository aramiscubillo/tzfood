/**
 * 
 */
package ts.tzfood.repositories;

import org.springframework.data.repository.CrudRepository;

import ts.tzfood.domain.Usuario;

/**
 * @author Aramis
 *
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findByUsername(String username);
}
