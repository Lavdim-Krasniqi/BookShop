package elbatech.bookshop.security.authentication.providers;

import elbatech.bookshop.security.authentication.utility.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenProvider implements AuthenticationProvider {

    @Autowired
    JwtTokenUtil tokenUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getPrincipal();

        if (tokenUtil.validateToken(token)) {
            return new TokenAuthentication(tokenUtil.getClaimsFromToken(token).get("username"),
                    null,
                    List.of(new SimpleGrantedAuthority(tokenUtil.getRole(token))));
        }
        throw new BadCredentialsException("Error");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(TokenAuthentication.class);
    }
}
