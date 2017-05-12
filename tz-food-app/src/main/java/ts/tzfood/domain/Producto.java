/**
 * 
 */
package ts.tzfood.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Aramis
 *
 */
@Entity
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private String nombre;
	private String tipo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
