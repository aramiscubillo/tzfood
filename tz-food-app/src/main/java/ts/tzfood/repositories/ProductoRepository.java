/**
 * 
 */
package ts.tzfood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ts.tzfood.domain.Producto;

/**
 * @author Aramis
 *
 */
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

	@Query("select DISTINCT p.nombre from  Producto p where p.marca = :marca and p.activo = true ORDER BY p.nombre ASC") 
	List<String> findByMarca(@Param("marca") String marca);
	
	@Query("select p from  Producto p where p.nombre = :nombre and p.activo = true ORDER BY p.presentacion ASC") 
	List<Producto> findByNombre(@Param("nombre") String nombre);
	
}
