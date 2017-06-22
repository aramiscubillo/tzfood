/**
 * 
 */
package ts.tzfood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ts.tzfood.domain.Producto;
import ts.tzfood.repositories.ProductoRepository;

/**
 * @author Aramis
 *
 */
@Service
public class ProductoService implements ProductoServiceInterface{

	@Autowired
	private ProductoRepository productoRepo;
	
	/* (non-Javadoc)
	 * @see ts.tzfood.services.ProductoServiceInterface#listProducto()
	 */
	@Override
	public Iterable<Producto> listProducto() {
		return productoRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.ProductoServiceInterface#getProducto(int)
	 */
	@Override
	public Producto getProducto(int id) {
		return productoRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.ProductoServiceInterface#saveProducto(ts.tzfood.domain.Producto)
	 */
	@Override
	public Producto saveProducto(Producto pedido) {
		return productoRepo.save(pedido);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.ProductoServiceInterface#deleteProducto(int)
	 */
	@Override
	public void deleteProducto(int id) {
		productoRepo.delete(id);
	}

	
	public List<String> getNombreProductosPorMarca(String nombre){
		return productoRepo.findByMarca(nombre);
	}
	
	
	public List<Producto> getProductosPorNombre(String nombre, String marca){
		return productoRepo.findByNombre(nombre, marca);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.ProductoServiceInterface#getMarcas(java.lang.String)
	 */
	@Override
	public List<String> getMarcas() {
		return productoRepo.findMarcas();
	}
}
