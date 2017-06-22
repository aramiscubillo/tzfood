/**
 * 
 */
package ts.tzfood.services;

import java.util.Date;

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
	
	Page<Pedido> find(PedidoSearchModel model);

	int getCantPedidosDia(Date date);
	
	
}
