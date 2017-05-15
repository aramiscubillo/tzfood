/**
 * 
 */
package ts.tzfood.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Aramis
 *
 */
@Entity
public class DetallePedido extends ObjetoBase{

	private boolean precio;
	private int cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPedido")
	private Pedido pedido;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	public boolean isPrecio() {
		return precio;
	}
	public void setPrecio(boolean precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
}
