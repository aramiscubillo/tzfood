/**
 * 
 */
package ts.tzfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Aramis
 *
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
	     return "views/login";
	}
	
}
