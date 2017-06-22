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
							+"<li>Realizar la transferencia o dep&oacute;sito a alguna de las cuentas de Territorio de Zaguates</li>"
							+"<li>Mandarle una foto del comprobante al n&uacute;mero 8888-3333 y con tu n&uacute;mero de c&eacute;dula</li>"
							+"<li>Te llegar&aactue; otro correo indicando que tu pedido ha sido marcado como pagado</li>"
						+"</ol>";
		
		String cuentas = "";
		
		if(efectivo){
			deposito = "<p>Te informaremos cuando tu pedido est&eacute; listo para ser entregado</p>";
		}else{
			cuentas= cuentas();
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
								"<p></p><br/>"+
								cuentas+
							"</body>"+
						"</html>";
		sender.send(email, html, "Pedido de alimento | Territorio de Zaguates");	
		
	}
	
	
	private String cuentas(){
		String cuentas = ""+
			"<h5>BAC San José</h5>"+
			"<ul>"+
			"<li>Cuenta de ahorro en colones: 918964842</li>"+
			"<li>Cuenta cliente para sinpe: 10200009189648426</li>"+
			"<li>Cuenta de ahorro en dólares: 908905698</li>"+ 
			"<li>Cuenta cliente para sinpe: 10200009089056981</li>"+
			"<li>Álvaro Enrique Saumet Martínez. Cédula costarricense: 8 0110 0888</li>"+
			"</ul>"+
			"<br/><br/>"+
			"<h5>Banco de Costa Rica / BCR</h5>" +
			"<ul>"+
			"<li>Cuenta de ahorro en colones: 001-1560373-3</li>"+
			"<li>Cuenta cliente para sinpe: 15202001156037334</li>"+
			"<li>Cuenta de ahorro en dólares: 001-1560377-6</li>"+
			"<li>Cuenta cliente para sinpe: 15202001156037765</li>"+
			"<li>Álvaro Enrique Saumet Martínez. Cédula costarricense: 8 0110 0888</li>"+
			"</ul>"+
			"<br/><br/>"+
			"<h5>Banco Nacional de CR</h5>"+
			"<ul>"+
			"<li>Cuenta de ahorro en colones: 200-01-208-108766-3</li>"+
			"<li>Cuenta cliente para sinpe: 15120820011087661</li>"+
			"<li>Cuenta de ahorro en dólares: 200-02-000-728510-3</li>"+
			"<li>Cuenta cliente para sinpe: 15100020027285103</li>"+
			"<li>Álvaro Enrique Saumet Martínez: Cédula costarricense: 8 0110 0888</li>"+
			"</ul>"+
			"<br/><br/>";

		return cuentas;
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
