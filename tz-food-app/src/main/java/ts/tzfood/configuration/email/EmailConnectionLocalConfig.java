package ts.tzfood.configuration.email;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;

import ts.tzfood.TzFoodAppApplication;
import ts.tzfood.constants.EmailConfigConstants;
import ts.tzfood.email.EmailAccountConfiguration;


// TODO: Auto-generated Javadoc
/**
 * The Class EmailConnectionLocalConfig.
 */
@Component
public class EmailConnectionLocalConfig implements EmailConnectionConfigInterface{

	/** The protocol. */
	private String EMAIL_PROTOCOL_VARIABLE = EmailConfigConstants.EMAIL_PROTOCOL_VARIABLE;
	   
   /** The host. */
	private String EMAIL_HOST_VARIABLE = EmailConfigConstants.EMAIL_HOST_VARIABLE;
   
   /** The port. */
    private int EMAIL_PORT_VARIABLE = EmailConfigConstants.EMAIL_PORT_VARIABLE;
   
   /** The auth. */
    private boolean EMAIL_AUTH_VARIABLE = EmailConfigConstants.EMAIL_AUTH_VARIABLE;
   
   /** The starttls. */
    private boolean EMAIL_TLS_VARIABLE = EmailConfigConstants.EMAIL_TLS_VARIABLE;
   
   /** The debug. */
    private boolean EMAIL_DEBUG_VARIABLE = EmailConfigConstants.EMAIL_DEBUG_VARIABLE;
   
   /** The Constant timeout. */
    private int EMAIL_TIMEOUT_VARIABLE = EmailConfigConstants.EMAIL_TIMEOUT_VARIABLE;
   
   /** The username. */
    private String EMAIL_USERNAME_VARIABLE = EmailConfigConstants.EMAIL_USERNAME_VARIABLE;
   
   /** The password. */
    private String EMAIL_PASSWORD_VARIABLE = EmailConfigConstants.EMAIL_PASSWORD_VARIABLE;
	
    
    
    public EmailConnectionLocalConfig(){
    	startEmailSession();
		TzFoodAppApplication.emailConfig = this;
    }
	
	/**
	 * Start email session.
	 *
	 * @author Fabián Vega Ramírez
	 */
	public void startEmailSession(){
		try {
			EmailAccountConfiguration.javaMailSession(EMAIL_PROTOCOL_VARIABLE,EMAIL_HOST_VARIABLE,EMAIL_PORT_VARIABLE,EMAIL_AUTH_VARIABLE,EMAIL_TLS_VARIABLE,EMAIL_DEBUG_VARIABLE,EMAIL_TIMEOUT_VARIABLE,EMAIL_USERNAME_VARIABLE,EMAIL_PASSWORD_VARIABLE);
			TzFoodAppApplication.transport.connect();
			
		} catch (MessagingException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			//TreeseedApplication.logger.error(sw.toString());
		}
	}

	
}