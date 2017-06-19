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
	public void emailPedidoHecho(int pedidoId, String url, String email, String nombrePersona, boolean efectivo) throws Exception{
		
		String deposito = "<p>Para completar tu orden debes realizar los siguientes pasos:</p>"
							+"<ol>"
							+"<li>Realizar la transferencia o dep&oacute;sito a la cuenta de Territorio de Zaguates</li>"
							+"<li>Mandarle una foto del comprobante al n&uacute;mero 8888-3333 y con tu n&uacute;mero de c&eacute;dula</li>"
							+"<li>Te llegar&aactue; otro correo indicando que tu pedido ha sido marcado como pagado</li>"
						+"</ol>";
		
		if(efectivo){
			deposito = "<p>Te informaremos cuando tu pedido est&eacute; listo para ser entregado</p>";
		}
		
		//todo
		String html = 	"<html>"+
							"<head><title>Pedido Realizado</title></head>"+
							"<body>"+
								"<p>Hola "+nombrePersona+"."+
								"<p>Este correo es para informate que tu pedido ha sido realizado.</p>"+
								deposito
								+ "<p>Puede consulta el "+
								"estado de su pedido <a href=\""+url+"\">aqu&iacute;</a> </p>"+
								"<p></p>"+
							"</body>"+
						"</html>";
		sender.send(email, html, "Pedido de alimento | Territorio de Zaguates");	
		
	}
	
	
	
	
	@Async
	public void emailPedidoConfirmado(int pedidoId, String url, String email, String nombrePersona) throws Exception{

		
		//todo
		String html = 	"<html>"+
							"<head><title>Pedido Confirmado</title></head>"+
							"<body>"+
								"<p>Hola "+nombrePersona+"."+
								"<p>Este correo es para informate que tu pedido est&aacute; listo y ser&aacute; entregado en los siguientes d&iacute;as.</p>"+
								"<p>Puede consulta el "+
								"estado de su pedido <a href=\""+url+"\">aqu&iacute;</a> </p>"+
								"<p></p>"+
							"</body>"+
						"</html>";
		sender.send(email, html, "Pedido listo | Territorio de Zaguates");	
		
	}
	
	
	
	@Async
	public void emailPedidoPagado(int pedidoId, String url, String email, String nombrePersona) throws Exception{

		
		//todo
		String html = 	"<html>"+
							"<head><title>Pedido Pagado</title></head>"+
							"<body>"+
								"<p>Hola "+nombrePersona+"."+
								"<p>Este correo es para informate que tu pedido ha sido ha sido marcado como pagado.</p>"+
								"<p>En los siguientes d&iacute;as te llegar&acute; otro correo para indicarte que tu pedido est&aacute; listo.</p>"+
								"<p>Puede consulta el "+
								"estado de su pedido <a href=\""+url+"\">aqu&iacute;</a> </p>"+
								"<p></p>"+
							"</body>"+
						"</html>";
		sender.send(email, html, "Pedido pagado | Territorio de Zaguates");	
		
	}
	
	

}
