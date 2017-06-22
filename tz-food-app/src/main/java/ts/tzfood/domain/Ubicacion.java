/**
 * 
 */
package ts.tzfood.domain;

import javax.persistence.Entity;

/**
 * @author Aramis
 *
 */
@Entity
public class Ubicacion extends ObjetoBase{


	private String nombre;
	private int regionPapa;
	private String fechaEntrega;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getRegionPapa() {
		return regionPapa;
	}
	public void setRegionPapa(int regionPapa) {
		this.regionPapa = regionPapa;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	
	
	
	
}
