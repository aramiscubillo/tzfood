/**
 * 
 */
package ts.tzfood.services;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Aramis
 *
 */
public class EncryptionService implements EncryptionServiceInterface{

	private StrongPasswordEncryptor strongEncryptor;
	 
    @Autowired
    public void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;
    }
 
    public String encryptString(String input){
        return strongEncryptor.encryptPassword(input);
    }
 
    public boolean checkPassword(String plainPassword, String encryptedPassword){
        return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
    }

}
