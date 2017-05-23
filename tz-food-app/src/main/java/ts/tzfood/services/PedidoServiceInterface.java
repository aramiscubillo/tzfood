/**
 * 
 */
package ts.tzfood.services;

import org.springframework.data.domain.Page;

import ts.tzfood.domain.Pedido;
import ts.tzfood.models.PedidoSearchModel;

/**
 * @author Aramis
 *
 */
public interface PedidoServiceInterface {

	Iterable<Pedido> listPedidos();
	
	Pedido getPedido(int id);
	
	Pedido savePedido(Pedido pedido);
	
	void deletePedido(int id);
	
	public Page<Pedido> find(PedidoSearchModel model);
	
}
