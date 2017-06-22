/**
 * 
 */
package ts.tzfood.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

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
	
	@OneToMany(mappedBy="encargadoDeAprobacion", fetch=FetchType.LAZY)
	private List<Pedido> pedidosAprobados;
	
	@OneToMany(mappedBy="encargadoDeEntrega", fetch=FetchType.LAZY)
	private List<Pedido> pedidosEntregados;
	
	
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

	public List<Pedido> getPedidosAprobados() {
		return pedidosAprobados;
	}

	public void setPedidosAprobados(List<Pedido> pedidosAprobados) {
		this.pedidosAprobados = pedidosAprobados;
	}

	public List<Pedido> getPedidosEntregados() {
		return pedidosEntregados;
	}

	public void setPedidosEntregados(List<Pedido> pedidosEntregados) {
		this.pedidosEntregados = pedidosEntregados;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	
    
    
	
	
}
