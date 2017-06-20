/**
 * 
 */
package ts.tzfood.jsonModels;

/**
 * @author Aramis
 *
 */
public class UbicacionJsonModel {
	
	private int id;
	private String nombre;
	private int regionPapa;
	private String fechaEntrega;
	
	/**
	 * 
	 */
	public UbicacionJsonModel() {
	
	}
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
