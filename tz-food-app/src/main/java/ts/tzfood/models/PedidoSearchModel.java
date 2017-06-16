/**
 * 
 */
package ts.tzfood.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import ts.tzfood.domain.Pedido;
import ts.tzfood.utils.Pager;

/**
 * @author Aramis
 *
 */
public class PedidoSearchModel {

	private Page<Pedido> pedidos;
	
	private String cedula;
	
	private String nombrePersona;
	
	private String pagado;
	
	private String entregado;
	
	private String listoParaEntrega;
	
	private String fechaCreacionInicio;
	
	private String fechaCreacionFin;
	
	private int pageNumber;
	
	private int pageSize;
	
	private Pager pager;
	
	private String newSearch;
	
	private String viewType;

	public Page<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Page<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getPagado() {
		return pagado;
	}

	public void setPagado(String pagado) {
		this.pagado = pagado;
	}

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public String getFechaCreacionInicio() {
		return fechaCreacionInicio;
	}

	public void setFechaCreacionInicio(String fechaCreacionInicio) {
		this.fechaCreacionInicio = fechaCreacionInicio;
	}

	public String getFechaCreacionFin() {
		return fechaCreacionFin;
	}

	public void setFechaCreacionFin(String fechaCreacionFin) {
		this.fechaCreacionFin = fechaCreacionFin;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getNewSearch() {
		return newSearch;
	}

	public void setNewSearch(String newSearch) {
		this.newSearch = newSearch;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getListoParaEntrega() {
		return listoParaEntrega;
	}

	public void setListoParaEntrega(String listoParaEntrega) {
		this.listoParaEntrega = listoParaEntrega;
	}
	
	
	
	
}
