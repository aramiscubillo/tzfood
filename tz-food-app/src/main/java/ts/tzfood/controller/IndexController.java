/**
 * 
 */
package ts.tzfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Aramis
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	String index(){
		return "views/index";
	}
	
}
