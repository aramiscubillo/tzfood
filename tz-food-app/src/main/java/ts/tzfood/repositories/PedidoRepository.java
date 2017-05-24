/**
 * 
 */
package ts.tzfood.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import ts.tzfood.domain.Pedido;

/**
 * @author Aramis
 *
 */
public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

	@Query("SELECT p FROM Pedido p WHERE "
			+ "( :cedula is null or p.cedulaPersona = :cedula ) and "
			+ "( :nombrePersonaNull  is null or LOWER(p.nombrePersona) like :nombrePersona  ) and "
			+ "( :pagadoNull  is null or p.pagado = :pagado ) and "
			+ "( :entregadoNull  is null or p.entregado = :entregado )  ")
			/*+ "( :fechaCreacInicio is null or p.fechaCreacion >= :fechaCreacInicio ) and "
			+ "( :fechaCreacFin is null or p.fechaCreacion <= :fechaCreacFin )")*/
	public Page<Pedido> find(
			@Param("cedula") String cedula,
			@Param("nombrePersonaNull") String nombrePersonaNull,
			@Param("nombrePersona") String nombrePersona,
			@Param("pagadoNull") String pagadoNull,
			@Param("pagado") boolean pagado,
			@Param("entregadoNull") String entregadoNull,
			@Param("entregado") boolean entregado,
			/*@Param("fechaCreacInicio") Date fechaCreacInicio, 
			@Param("fechaCreacFin") Date fechaCreacFin,*/
			Pageable pageable);
	
}
