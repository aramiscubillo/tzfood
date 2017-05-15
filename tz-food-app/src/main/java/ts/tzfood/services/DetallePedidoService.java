/**
 * 
 */
package ts.tzfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ts.tzfood.domain.DetallePedido;
import ts.tzfood.repositories.DetallePedidoRepository;
import ts.tzfood.repositories.PedidoRepository;

/**
 * @author Aramis
 *
 */
@Service
public class DetallePedidoService  implements DetallePedidoServiceInterface{

	@Autowired
	private DetallePedidoRepository detallePedidoRepo;

	/* (non-Javadoc)
	 * @see ts.tzfood.services.DetallePedidoServiceInterface#getDetallePedido(int)
	 */
	@Override
	public DetallePedido getDetallePedido(int id) {
		return detallePedidoRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.DetallePedidoServiceInterface#savePedido(ts.tzfood.domain.Pedido)
	 */
	@Override
	public DetallePedido savePedido(DetallePedido pedido) {
		return detallePedidoRepo.save(pedido);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.DetallePedidoServiceInterface#deletePedido(int)
	 */
	@Override
	public void deletePedido(int id) {
		detallePedidoRepo.delete(id);
		
	}

	
}
