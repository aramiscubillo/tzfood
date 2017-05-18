/**
 * 
 */
package ts.tzfood.models;

import ts.tzfood.domain.Pedido;

/**
 * @author Aramis
 *
 */
public class PedidoModel {
	
	private Pedido pedido;
	private String productosList;
	
	
	
	/**
	 * 
	 */
	public PedidoModel() {
		pedido = new Pedido();
		productosList = "";
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public String getProductosList() {
		return productosList;
	}
	public void setProductosList(String productosList) {
		this.productosList = productosList;
	}
	
	
	
	
}
