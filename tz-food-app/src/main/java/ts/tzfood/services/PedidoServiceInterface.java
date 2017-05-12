/**
 * 
 */
package ts.tzfood.services;

import ts.tzfood.domain.Pedido;

/**
 * @author Aramis
 *
 */
public interface PedidoServiceInterface {

	Iterable<Pedido> listPedidos();
	
	Pedido getPedido(int id);
	
	Pedido savePedido(Pedido pedido);
	
	void deletePedido(int id);
	
}
