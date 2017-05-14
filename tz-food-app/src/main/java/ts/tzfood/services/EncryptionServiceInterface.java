/**
 * 
 */
package ts.tzfood.services;

/**
 * @author Aramis
 *
 */
public interface EncryptionServiceInterface {
	String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
