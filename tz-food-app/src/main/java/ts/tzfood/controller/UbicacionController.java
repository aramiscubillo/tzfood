/**
 * 
 */
package ts.tzfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ts.tzfood.domain.Ubicacion;
import ts.tzfood.mappers.UbicacionMapper;
import ts.tzfood.services.UbicacionServiceInterface;


@Controller
public class UbicacionController {

	private UbicacionMapper mapper = new UbicacionMapper();
	
	@Autowired
	private UbicacionServiceInterface ubicacionService;
	
	@RequestMapping(value = "ubicacion/getRegionByRegionPapa", method = RequestMethod.GET)
    public @ResponseBody List<Ubicacion> getRegionByRegionPapa( @RequestParam(value = "regionPapa", required = true) int regionPapa) {
       
		return ubicacionService.getUbicacionByRegionPapa(regionPapa);
    }
	
	
}
