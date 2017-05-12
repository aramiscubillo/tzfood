/**
 * 
 */
package ts.tzfood.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Aramis
 *
 */
@Entity
public class Pedido {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombrePersona;
    private Date fechaCreacion;
    private String direccion;
    private String tocken;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTocken() {
		return tocken;
	}
	public void setTocken(String tocken) {
		this.tocken = tocken;
	}
	
    
    
}
