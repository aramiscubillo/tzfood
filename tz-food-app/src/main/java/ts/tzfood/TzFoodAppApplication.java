package ts.tzfood;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Executor;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import ts.tzfood.configuration.email.EmailConnectionConfigInterface;

@EnableAsync
@SpringBootApplication
public class TzFoodAppApplication {

	/** The Constant logger. */
	public static final Logger logger = Logger.getLogger(TzFoodAppApplication.class);

	/** *************************** Mail variables BEGINS ****************************. */

	/** The Constant session. */
	//Firt Create Mail Session
	public static Session session;
	
	/** The Constant transport. */
	//Then get the Transport from the Session above
	public static Transport transport;

	
	/** The email config. */
	public static EmailConnectionConfigInterface emailConfig;
	
	/** *************************** Mail variables END ****************************. */
	
	
	public static void main(String[] args) {
		SpringApplication.run(TzFoodAppApplication.class, args);
	}
	
	
	
	/**
	 * Restart email session.
	 * @throws MessagingException 
	 *
	 */
	public static void restartEmailSession() {
		try{
			TzFoodAppApplication.logger.info("Reconnecting email service...");
			transport.connect();
			TzFoodAppApplication.logger.info("Email service reconnected.");
		}catch(Exception e){
			TzFoodAppApplication.logger.error("Fail to reconnected email service.");
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);TzFoodAppApplication.logger.error(sw.toString());
		}
	}

	/**
	 * Chooses the Task executor for Async functions
	 */
	@Bean
    public Executor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
}
