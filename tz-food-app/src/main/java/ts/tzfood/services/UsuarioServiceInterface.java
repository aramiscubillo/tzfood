/**
 * 
 */
package ts.tzfood.services;


import ts.tzfood.domain.Usuario;

/**
 * @author Aramis
 *
 */
public interface UsuarioServiceInterface {

	Iterable<Usuario> listAll();
	
	Usuario getById(Integer id);
	 
	Usuario saveOrUpdate(Usuario usuario);
	 
	void delete(int id);
	
	Usuario findByUserName(String username);

}
