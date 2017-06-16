/**
 * 
 */
package ts.tzfood.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ts.tzfood.domain.Pedido;
import ts.tzfood.models.PedidoSearchModel;
import ts.tzfood.repositories.PedidoRepository;

/**
 * @author Aramis
 *
 */
@Service
public class PedidoService  implements PedidoServiceInterface{

	@Autowired
	private PedidoRepository pedidoRepo;

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#listPedidos()
	 */
	@Override
	public Iterable<Pedido> listPedidos() {
		return pedidoRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#getPedido(int)
	 */
	@Override
	public Pedido getPedido(int id) {
		return pedidoRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#savePedido(ts.tzfood.domain.Pedido)
	 */
	@Override
	public Pedido savePedido(Pedido pedido) {
		return pedidoRepo.save(pedido);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#deletePedido(int)
	 */
	@Override
	public void deletePedido(int id) {
		pedidoRepo.delete(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#find()
	 */
	@Override
	public Page<Pedido> find(PedidoSearchModel model) {
		
		String cedula = null;
		String nombrePersonaNull = null;
		String nombrePersona = null;
		String pagadoNull = null;
		boolean pagado = false;
		String entregadoNull = null;
		String listoNull = null;
		boolean listo = false;
		boolean entregado = false;
		Date fechaCreacInicio = null;
		Date fechaCreacFin = null;
		PageRequest pr = null;
		
		
		
		
		Sort sort = new Sort(Sort.Direction.DESC, "fechaCreacion");
		pr = new PageRequest(model.getPageNumber(), model.getPageSize(), sort);
		
		Page<Pedido> result = null;

		if(model.getCedula() != null && model.getCedula().length()>0){
			cedula = model.getCedula();
		}
		
		if(model.getNombrePersona() != null && model.getNombrePersona().length()>0){
			nombrePersonaNull = model.getNombrePersona();
			nombrePersona = "%"+model.getNombrePersona().toLowerCase()+"%";
		}
		
		if(model.getPagado() != null && model.getPagado().length()>0){
			pagadoNull = model.getPagado();
			pagado = model.getPagado().equals("Si")? true:false;
		}
		
		if(model.getEntregado() != null && model.getEntregado().length()>0){
			entregadoNull = model.getEntregado();
			entregado = model.getEntregado().equals("Si")? true:false;
		}
		
		if(model.getListoParaEntrega() != null && model.getListoParaEntrega().length()>0){
			listoNull = model.getListoParaEntrega();
			listo = model.getListoParaEntrega().equals("Si")? true:false;
		}
		
		return pedidoRepo.find(cedula, nombrePersonaNull, nombrePersona, 
							pagadoNull, pagado, entregadoNull, entregado,
							listoNull, listo,
							  pr);
		
	}
	
	
	
}
