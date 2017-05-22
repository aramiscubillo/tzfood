package ts.tzfood.configuration.email;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmailConnectionConfigInterface.
 */
public interface EmailConnectionConfigInterface{
	
	/** The protocol. */
	final String EMAIL_PROTOCOL_VARIABLE="";
    
    /** The host. */
	final String EMAIL_HOST_VARIABLE="";
    
    /** The port. */
	final int EMAIL_PORT_VARIABLE=0;
    
    /** The auth. */
	final boolean EMAIL_AUTH_VARIABLE=false;
    
    /** The starttls. */
	final boolean EMAIL_TLS_VARIABLE=false;
    
    /** The debug. */
	final boolean EMAIL_DEBUG_VARIABLE=false;
    
    /** The Constant timeout. */
	final int EMAIL_TIMEOUT_VARIABLE=0;
    
    /** The username. */
	final String EMAIL_USERNAME_VARIABLE="";
    
    /** The password. */
	final String EMAIL_PASSWORD_VARIABLE="";
	
	/**
	 * Start email session.
	 *
	 * @author Fabián Vega Ramírez
	 */
	void startEmailSession();

	
}
