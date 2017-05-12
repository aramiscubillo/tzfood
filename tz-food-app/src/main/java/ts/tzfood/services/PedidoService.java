/**
 * 
 */
package ts.tzfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ts.tzfood.domain.Pedido;
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
	
}
