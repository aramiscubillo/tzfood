/**
 * 
 */
package ts.tzfood.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ts.tzfood.domain.DetallePedido;
import ts.tzfood.domain.Pedido;
import ts.tzfood.jsonModels.DetallePedidoJsonModel;
import ts.tzfood.jsonModels.PedidoJsonModel;

/**
 * @author Aramis
 *
 */
@Component
public class PedidoMapper implements Mapper<Pedido,PedidoJsonModel>{

	/* (non-Javadoc)
	 * @see ts.tzfood.mappers.Mapper#mapToJsonModel(java.lang.Object)
	 */
	@Override
	public PedidoJsonModel mapToJsonModel(Pedido object) {
		
		PedidoJsonModel model = new PedidoJsonModel();
		model.setId(object.getId());
		model.setCedulaPersona(object.getCedulaPersona());
		model.setNombrePersona(object.getNombrePersona());
		model.setEmail(object.getEmail());
		model.setFechaPago(object.getFechaPago());
		model.setFechaEntrega(object.getFechaEntrega());
		model.setDisponibilidad(object.getDisponibilidad());
		model.setListoParaEntrega(object.isListoParaEntrega());
		model.setPagado(object.isPagado());
		model.setEntregado(object.isEntregado());
		model.setEfectivo(object.isEfectivo());
		model.setToken(object.getToken());
		model.setProvincia(object.getProvincia());
		model.setCanton(object.getCanton());
		model.setTelefono(object.getTelefono());
		model.setTelefonoOficina(object.getTelefonoOficina());
		
		List<DetallePedidoJsonModel> detalles = new ArrayList<DetallePedidoJsonModel>();
		DetallePedidoJsonModel detalleJson = null;
		
		for (DetallePedido detalle : object.getDetalles()) {
		   
			detalleJson = new DetallePedidoJsonModel();
			
			detalleJson.setId(detalle.getId());
			detalleJson.setCantidad(detalle.getCantidad());
			detalleJson.setPrecio(detalle.getPrecio());
			detalleJson.setProducto(detalle.getProducto());
			
			detalles.add(detalleJson);
			
		}
		
		model.setDetalles(detalles);
		
		return model;
	}

	@Override
	public Pedido mapToObject(PedidoJsonModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoJsonModel> mapToJsonModel(List<Pedido> objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> mapToObject(List<PedidoJsonModel> models) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
