/**
 * 
 */
package ts.tzfood.services;

import java.util.List;

import ts.tzfood.domain.Producto;

/**
 * @author Aramis
 *
 */
public interface ProductoServiceInterface {

	Iterable<Producto> listProducto();
	
	Producto getProducto(int id);
	
	Producto saveProducto(Producto pedido);
	
	void deleteProducto(int id);
	
	List<String> getNombreProductosPorMarca(String nombre);
	
	List<String> getMarcas();
	
	List<Producto> getProductosPorNombre(String nombre, String marca);
}
