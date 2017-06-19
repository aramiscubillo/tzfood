/**
 * 
 */
package ts.tzfood.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ts.tzfood.domain.Pedido;
import ts.tzfood.models.PedidoSearchModel;
import ts.tzfood.repositories.PedidoRepository;

/**
 * @author Aramis
 *
 */
@Service
public class PedidoService  implements PedidoServiceInterface{

	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired 
	private UbicacionServiceInterface ubicacionService;

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#listPedidos()
	 */
	@Override
	public Iterable<Pedido> listPedidos() {
		return pedidoRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#getPedido(int)
	 */
	@Override
	public Pedido getPedido(int id) {
		return pedidoRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#savePedido(ts.tzfood.domain.Pedido)
	 */
	@Override
	public Pedido savePedido(Pedido pedido) {
		return pedidoRepo.save(pedido);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#deletePedido(int)
	 */
	@Override
	public void deletePedido(int id) {
		pedidoRepo.delete(id);
	}

	/* (non-Javadoc)
	 * @see ts.tzfood.services.PedidoServiceInterface#find()
	 */
	@Override
	public Page<Pedido> find(PedidoSearchModel model) {
		
		String cedulaNull = null;
		String cedula = null;
		String nombrePersonaNull = null;
		String nombrePersona = null;
		String pagadoNull = null;
		boolean pagado = false;
		String entregadoNull = null;
		String listoNull = null;
		boolean listo = false;
		boolean entregado = false;
		Date fechaCreacInicio = null;
		Date fechaCreacFin = null;
		String provincia = null;
		String canton = null;
		PageRequest pr = null;
		
		
		try{
		
			Sort sort = new Sort(Sort.Direction.DESC, "fechaCreacion");
			pr = new PageRequest(model.getPageNumber(), model.getPageSize(), sort);
			
			Page<Pedido> result = null;
	
			
			if(model.getCedula() != null && model.getCedula().length()>0){
				cedulaNull = model.getCedula();
				cedula = "%"+model.getCedula().toLowerCase()+"%";
			}
			
			if(model.getNombrePersona() != null && model.getNombrePersona().length()>0){
				nombrePersonaNull = model.getNombrePersona();
				nombrePersona = "%"+model.getNombrePersona().toLowerCase()+"%";
			}
			
			if(model.getPagado() != null && model.getPagado().length()>0){
				pagadoNull = model.getPagado();
				pagado = model.getPagado().equals("Si")? true:false;
			}
			
			if(model.getEntregado() != null && model.getEntregado().length()>0){
				entregadoNull = model.getEntregado();
				entregado = model.getEntregado().equals("Si")? true:false;
			}
			
			if(model.getListoParaEntrega() != null && model.getListoParaEntrega().length()>0){
				listoNull = model.getListoParaEntrega();
				listo = model.getListoParaEntrega().equals("Si")? true:false;
			}
			
			if(model.getFechaCreacionInicio() != null && model.getFechaCreacionInicio().length()>0){
				fechaCreacInicio = getDate(model.getFechaCreacionInicio());
			}
			
			if(model.getFechaCreacionFin() != null && model.getFechaCreacionFin().length()>0){
				fechaCreacFin = getDate(model.getFechaCreacionFin());
			}
			
			
			if(model.getProvincia() != null && model.getProvincia().length()>0){
				provincia = ubicacionService.getLugar(Integer.parseInt(model.getProvincia())).getNombre();
			}
			
			if(model.getCanton() != null && model.getCanton().length()>0){
				canton = ubicacionService.getLugar(Integer.parseInt(model.getCanton())).getNombre();
			}
			
			if(model.getViewType().equals("general")){
				
				return pedidoRepo.findGeneral(cedulaNull, cedula, nombrePersonaNull, nombrePersona, 
								pagadoNull, pagado, entregadoNull, entregado,
								listoNull, listo, fechaCreacInicio, fechaCreacFin, provincia, canton,
								  pr);		
			}else{
				return pedidoRepo.findEntrega(cedulaNull, cedula, nombrePersonaNull, nombrePersona, 
						 fechaCreacInicio, fechaCreacFin, provincia, canton,
						  pr);	
			}
		
		} catch(Exception e){
			return null;
		}
	}
	
		
	 private Date getDate(String dateString) throws Exception{
	    	
    	DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 

    	return df.parse(dateString);
    	
    }
	
	
}
