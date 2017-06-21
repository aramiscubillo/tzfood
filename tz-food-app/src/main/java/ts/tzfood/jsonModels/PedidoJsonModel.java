/**
 * 
 */
package ts.tzfood.jsonModels;

import java.util.Date;

/**
 * @author Aramis
 *
 */
public class PedidoJsonModel {
	
	private int id;
	private String cedulaPersona;
    private String nombrePersona;
    private String email;
    private Date fechaPago;
    private Date fechaEntrega;
    private String disponibilidad;
    private boolean listoParaEntrega;
    private boolean pagado;
    private boolean entregado;
    private boolean efectivo;
    private String token;
    private String provincia;
    private String canton;
    private String telefono;
    private String telefonoOficina;
	/**
	 * 
	 */
	public PedidoJsonModel() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedulaPersona() {
		return cedulaPersona;
	}
	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public boolean isListoParaEntrega() {
		return listoParaEntrega;
	}
	public void setListoParaEntrega(boolean listoParaEntrega) {
		this.listoParaEntrega = listoParaEntrega;
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
	public boolean isEfectivo() {
		return efectivo;
	}
	public void setEfectivo(boolean efectivo) {
		this.efectivo = efectivo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCanton() {
		return canton;
	}
	public void setCanton(String canton) {
		this.canton = canton;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelefonoOficina() {
		return telefonoOficina;
	}
	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}
	
	
	
}
