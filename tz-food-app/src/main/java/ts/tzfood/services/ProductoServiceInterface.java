/**
 * 
 */
package ts.tzfood.services;

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
}
