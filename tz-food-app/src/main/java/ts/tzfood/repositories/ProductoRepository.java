/**
 * 
 */
package ts.tzfood.repositories;

import org.springframework.data.repository.CrudRepository;
import ts.tzfood.domain.Producto;

/**
 * @author Aramis
 *
 */
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

}
