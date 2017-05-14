/**
 * 
 */
package ts.tzfood.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ts.tzfood.domain.Usuario;
import ts.tzfood.services.UsuarioServiceInterface;

/**
 * @author Aramis
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioServiceInterface usuarioService;
	
    private Converter<Usuario, UserDetails> usuarioUserDetailsConverter;

    @Autowired
    @Qualifier(value = "usuarioToUserDetails")
    public void setUserUserDetailsConverter(Converter<Usuario, UserDetails> usuarioUserDetailsConverter) {
        this.usuarioUserDetailsConverter = usuarioUserDetailsConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioUserDetailsConverter.convert(usuarioService.findByUserName(username));
    }
	
}
