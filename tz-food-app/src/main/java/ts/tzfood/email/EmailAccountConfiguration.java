package ts.tzfood.email;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import org.springframework.context.annotation.Configuration;
import ts.tzfood.TzFoodAppApplication;

// TODO: Auto-generated Javadoc
/**
 * The Class MailConfiguration.
 */
@Configuration
public class EmailAccountConfiguration {
	
	
    /** The session. */
    private static Session session;

    /**
     * Java mail sender.
     *
     * @return the java mail sender
     */
    public static void javaMailSession(String EMAIL_PROTOCOL_VARIABLE,String EMAIL_HOST_VARIABLE,int EMAIL_PORT_VARIABLE,boolean EMAIL_AUTH_VARIABLE,boolean EMAIL_SSL_VARIABLE,boolean EMAIL_DEBUG_VARIABLE,int EMAIL_TIMEOUT_VARIABLE,String EMAIL_USERNAME_VARIABLE,String EMAIL_PASSWORD_VARIABLE) {    	
        Properties mailProperties = System.getProperties();
        
        mailProperties.put("mail.smtp.port", EMAIL_PORT_VARIABLE);
        mailProperties.put("mail.smtp.host", EMAIL_HOST_VARIABLE);
        mailProperties.put("mail.smtp.auth", EMAIL_AUTH_VARIABLE);
        mailProperties.put("mail.smtp.starttls.enable", EMAIL_SSL_VARIABLE);
        mailProperties.put("mail.debug", EMAIL_DEBUG_VARIABLE);
        mailProperties.put("mail.smtp.timeout", EMAIL_TIMEOUT_VARIABLE);
        mailProperties.put("mail.smtp.socketFactory.fallback", false);
        mailProperties.put("mail.smtp.socketFactory.port", EMAIL_PORT_VARIABLE);
        /* mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailProperties.put("mail.smtp.ssl.trust", "*");*/
    	
        if(EMAIL_AUTH_VARIABLE){
        	session = Session.getDefaultInstance(mailProperties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL_USERNAME_VARIABLE,EMAIL_PASSWORD_VARIABLE);
                }
            });
        }else{
        	session = Session.getDefaultInstance(mailProperties);
        }    	
    	
        TzFoodAppApplication.session = session;	
    	javaMailTransport(EMAIL_PROTOCOL_VARIABLE);
    }
    
    /**
     * Java mail transport.
     *
     * @return the transport
     */
    public static void javaMailTransport(String protocol) {
    	try{
    		Transport transport = session.getTransport(protocol);
    		TzFoodAppApplication.transport = transport;
		} catch (NoSuchProviderException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			//treeseedinfo@gmail.com.logger.error(sw.toString());
		}
    }


	
}
