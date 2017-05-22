package ts.tzfood.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


// TODO: Auto-generated Javadoc
/**
 * The Class Utils.
 */
@Component
public class EmailTemplateUtils {
	
	/** The sender. */
	@Autowired
	private MailSender sender;
	
	
	/**
	 * Email receipt.
	 *
	 * @param donation the donation
	 * @param donorEmail the donor email
	 * @param nonprofitName the nonprofit name
	 * @param language the language
	 * @throws Exception the exception
	 */
	@Async
	public void emailPedidoHecho(int pedidoId, String url, String email, String nombrePersona) throws Exception{
		
		//todo
		String html = 	"<html>"+
							"<head><title>Pedido Realizado #"+pedidoId+"</title></head>"+
							"<body>"+
								"<p>Hola "+nombrePersona+"."+
								"<p>Este correo es para informate que tu pedido ha sido realizado. Puede consulta el "+
								"estado de su pedido <a href=\""+url+"\">aqu&iacute;</a> </p>"+
								"<p>N&uacute;mero de Pedido: "+pedidoId+"</p>"+
							"</body>"+
						"</html>";
		sender.send(email, html, "Pedido de alimento | Territorio de Zaguates #"+pedidoId);	
		
	}
	
	
	

}
