/**
 * 
 */
package ts.tzfood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ts.tzfood.domain.Ubicacion;


public interface UbicacionRepository extends CrudRepository<Ubicacion, Integer>{

	@Query("select DISTINCT u from  Ubicacion u where u.regionPapa = :regionPapa and u.activo = true ORDER BY u .nombre ASC") 
	List<Ubicacion> findByRegionPapa(@Param("regionPapa") int regionPapa);

}
