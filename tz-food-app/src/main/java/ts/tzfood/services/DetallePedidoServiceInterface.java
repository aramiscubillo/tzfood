/**
 * 
 */
package ts.tzfood.services;

import ts.tzfood.domain.DetallePedido;

/**
 * @author Aramis
 *
 */
public interface DetallePedidoServiceInterface {

	
	DetallePedido getDetallePedido(int id);
	
	DetallePedido savePedido(DetallePedido pedido);
	
	void deletePedido(int id);
	
}
