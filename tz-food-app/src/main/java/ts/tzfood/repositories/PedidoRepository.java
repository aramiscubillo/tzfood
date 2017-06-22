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
			+ "( :cedulaNull  is null or LOWER(p.cedulaPersona) like :cedula  ) and "
			+ "( :nombrePersonaNull  is null or LOWER(p.nombrePersona) like :nombrePersona  ) and "
			+ "( :pagadoNull  is null or p.pagado = :pagado ) and "
			+ "( :listoNull  is null or p.listoParaEntrega = :listo ) and "
			+ "( :entregadoNull  is null or p.entregado = :entregado )  and "
			+ " p.activo = 1 and " 
			+ "( :provincia is null or p.provincia = :provincia ) and "
			+ "( :canton is null or p.canton = :canton ) and "
			+ "( :fechaCreacInicio is null or Date(p.fechaCreacion) >= Date(:fechaCreacInicio) ) and "
			+ "( :fechaCreacFin is null or Date(p.fechaCreacion) <= Date(:fechaCreacFin) )")
	public Page<Pedido> findGeneral(
			@Param("cedulaNull") String cedulaNull,
			@Param("cedula") String cedula,
			@Param("nombrePersonaNull") String nombrePersonaNull,
			@Param("nombrePersona") String nombrePersona,
			@Param("pagadoNull") String pagadoNull,
			@Param("pagado") boolean pagado,
			@Param("entregadoNull") String entregadoNull,
			@Param("entregado") boolean entregado,
			@Param("listoNull") String listoNull,
			@Param("listo") boolean listo,
			@Param("fechaCreacInicio") Date fechaCreacInicio, 
			@Param("fechaCreacFin") Date fechaCreacFin,
			@Param("provincia") String provincia, 
			@Param("canton") String canton,
			Pageable pageable);
	
	
	
	@Query("SELECT p FROM Pedido p WHERE "
			+ "( :cedulaNull  is null or LOWER(p.cedulaPersona) like :cedula  ) and "
			+ "( :nombrePersonaNull  is null or LOWER(p.nombrePersona) like :nombrePersona  ) and "
			+ "( p.pagado = 1 or p.efectivo = 1 ) and "
			+ "( p.listoParaEntrega = 1 ) and "
			+ "( p.entregado = 0 )  and "
			+ " p.activo = 1 and " 
			+ "( :provincia is null or p.provincia = :provincia ) and "
			+ "( :canton is null or p.canton = :canton ) and "
			+ "( :fechaCreacInicio is null or Date(p.fechaCreacion) >= Date(:fechaCreacInicio) ) and "
			+ "( :fechaCreacFin is null or Date(p.fechaCreacion) <= Date(:fechaCreacFin) )")
	public Page<Pedido> findEntrega(
			@Param("cedulaNull") String cedulaNull,
			@Param("cedula") String cedula,
			@Param("nombrePersonaNull") String nombrePersonaNull,
			@Param("nombrePersona") String nombrePersona,
			@Param("fechaCreacInicio") Date fechaCreacInicio, 
			@Param("fechaCreacFin") Date fechaCreacFin,
			@Param("provincia") String provincia, 
			@Param("canton") String canton,
			Pageable pageable);



	@Query("SELECT count(id) FROM Pedido p WHERE "
			+ "( DAY(p.fechaCreacion)= :dia ) and "
			+ "( MONTH(p.fechaCreacion)= :mes)")
	public int getPedidosDia(
			@Param("dia") int dia,
			@Param("mes") int mes);
	
}
