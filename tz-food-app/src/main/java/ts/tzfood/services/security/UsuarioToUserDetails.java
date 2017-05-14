/**
 * 
 */
package ts.tzfood.services.security;


import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import ts.tzfood.domain.Usuario;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UsuarioToUserDetails implements Converter<Usuario, UserDetails> {
    
	@Override
    public UserDetails convert(Usuario usuario) {
    	
        UserDetailsImpl userDetails = new UserDetailsImpl();

        if (usuario != null) {
            userDetails.setUsername(usuario.getUsername());
            userDetails.setPassword(usuario.getEncryptedPassword());
            userDetails.setEnabled(usuario.getEnabled());
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            
            authorities.add(new SimpleGrantedAuthority(usuario.getRol()));
            
            userDetails.setAuthorities(authorities);
        }

        return userDetails;
    }
}
