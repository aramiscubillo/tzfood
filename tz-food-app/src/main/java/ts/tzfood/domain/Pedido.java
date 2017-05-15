/**
 * 
 */
package ts.tzfood.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * @author Aramis
 *
 */
@Entity
public class Pedido extends ObjetoBase{

	private String cedulaPersona;
    private String nombrePersona;
    private Date fechaPago;
    private Date fechaEntrega;
    private String disponibilidad;
    private boolean pagado;
    private boolean entregado;
    private String token;
    
    @OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_ubicacion")
    private Ubicacion ubicacion;
    
    @OneToMany(mappedBy="pedido")
    private List<DetallePedido> detalles;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEncargadoAprobacion")
    private Usuario encargadoDeAprobacion;
    
    @ManyToOne(fetch=FetchType.LAZY)
  	@JoinColumn(name="idEncargadoEntrega")
    private Usuario encargadoDeEntrega;
    
    
    

	/**
	 * 
	 */
	public Pedido() {
		super();
		detalles = new ArrayList<DetallePedido>();
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public List<DetallePedido> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}
	public Usuario getEncargadoDeAprobacion() {
		return encargadoDeAprobacion;
	}
	public void setEncargadoDeAprobacion(Usuario encargadoDeAprobacion) {
		this.encargadoDeAprobacion = encargadoDeAprobacion;
	}
	public Usuario getEncargadoDeEntrega() {
		return encargadoDeEntrega;
	}
	public void setEncargadoDeEntrega(Usuario encargadoDeEntrega) {
		this.encargadoDeEntrega = encargadoDeEntrega;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getToken() {
		return token;
	}
	public void setTocken(String token) {
		this.token = token;
	}
	public String getCedulaPersona() {
		return cedulaPersona;
	}
	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public boolean isEntregado() {
		return entregado;
	}
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
    
    
}
