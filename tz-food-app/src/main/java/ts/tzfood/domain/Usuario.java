/**
 * 
 */
package ts.tzfood.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aramis
 *
 */
@Entity
public class Usuario extends ObjetoBase{

	private String username;

	@Transient
	private String password;
	
	private String encryptedPassword;
	private Boolean enabled = true;
	
	private String rol;
	private int failedLoginAttempts = 0;
	
	
	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
    
    
	
	
}
