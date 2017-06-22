package ts.tzfood.email;

import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

import ts.tzfood.TzFoodAppApplication;
import ts.tzfood.constants.EmailConfigConstants;



// TODO: Auto-generated Javadoc
/**
 * The Class MailSender.
 */
@Component
public class MailSender {

	
	/**
	 * Send V2.
	 *
	 * @author Fabián Vega Ramírez
	 * @param sendTo the send to
	 * @param html the html
	 * @param subject the subject
	 * @throws Exception the exception
	 */
	public  void send(String sendTo, String html, String subject ) throws Exception{ 
		Message mimeMessage = new MimeMessage(TzFoodAppApplication.session);

		mimeMessage.setContent(html, "text/html; charset=UTF-8");
		String from = "treeseedinfo@gmail.com";
		
		mimeMessage.setFrom(new InternetAddress(from,"Treeseed.org"));
		
		InternetAddress[] to = {new InternetAddress(sendTo)};
		mimeMessage.setRecipients(Message.RecipientType.TO, to);
		
		mimeMessage.setSubject(subject);
		mimeMessage.setSentDate(new Date());
		
		if(!TzFoodAppApplication.transport.isConnected()){
			TzFoodAppApplication.restartEmailSession();
		}
		TzFoodAppApplication.transport.send(mimeMessage);
	};
	
	
	/**
	 * Send with attachment.
	 *
	 * @author Fabián Vega Ramírez
	 * @param sendTo the send to
	 * @param html the html
	 * @param subject the subject
	 * @param attachments the attachments
	 * @throws Exception the exception
	 */
	public void sendWithAttachment(String sendTo, String html, String subject, List<String> attachments) throws Exception{ 
		Message mimeMessage = new MimeMessage(TzFoodAppApplication.session);
		String path ="";
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(html, "text/html; charset=UTF-8");

		Multipart multipart = new MimeMultipart("mixed");  
		for(String attachment:attachments){
			if(attachment!=null){
				String[] attachmentName = attachment.split("/");
				
				path = attachment;
				
				MimeBodyPart attachmentPart = new MimeBodyPart();
				DataSource source = new FileDataSource(path);
				attachmentPart.setDataHandler(new DataHandler(source));	
				attachmentPart.setFileName(attachmentName[attachmentName.length-1]);
				
		        multipart.addBodyPart(attachmentPart); 
			}
		}
		  
        multipart.addBodyPart(bodyPart);     
        mimeMessage.setContent(multipart);
		
        String from = EmailConfigConstants.EMAIL_FROM_ADDRESS;
		
		mimeMessage.setFrom(new InternetAddress(from,"Treeseed.org"));
        
		
		
		InternetAddress[] to = {new InternetAddress(sendTo)};
		mimeMessage.setRecipients(Message.RecipientType.TO, to);
		
		
		mimeMessage.setSubject(subject);
		mimeMessage.setSentDate(new Date());
		
		if(!TzFoodAppApplication.transport.isConnected()){
			TzFoodAppApplication.restartEmailSession();
		}
		TzFoodAppApplication.transport.send(mimeMessage);
	};
	
	
	
	
	
}
