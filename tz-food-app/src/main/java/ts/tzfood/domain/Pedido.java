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
public class Pedido extends ObjetoBase{

    private String nombrePersona;
    private Date fechaCreacion;
    private String direccion;
    private String token;
    

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
	public String getToken() {
		return token;
	}
	public void setTocken(String token) {
		this.token = token;
	}
	
    
    
}
