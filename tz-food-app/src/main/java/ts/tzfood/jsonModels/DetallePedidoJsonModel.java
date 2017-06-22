/**
 * 
 */
package ts.tzfood.jsonModels;

import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ts.tzfood.domain.DetallePedido;
import ts.tzfood.domain.Pedido;
import ts.tzfood.domain.Producto;

/**
 * @author Aramis
 *
 */
public class DetallePedidoJsonModel {
	
	private int id;
	private double precio;
	private int cantidad;
	private Producto producto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
	
	
}
