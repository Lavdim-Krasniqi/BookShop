package elbatech.bookshop.security.authentication.filters;

import elbatech.bookshop.security.authentication.providers.UsernamePasswordAuthentication;
import elbatech.bookshop.security.authentication.utility.JwtTokenUtil;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UsernamePasswordFilter extends OncePerRequestFilter {


    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver exceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String username = request.getHeader("username");
        String password = request.getHeader("password");


        if (username == null || password == null)
            exceptionResolver.resolveException(request, response,
                    null, new RuntimeException("Username and Password are missing"));
        else {
            try {

                val authentication = new UsernamePasswordAuthentication(username, password);
                Authentication a = manager.authenticate(authentication);


                String role = a.getAuthorities().stream().filter(grantedAuthority ->
                                grantedAuthority.getAuthority().startsWith("ROLE_"))
                        .findFirst().map(GrantedAuthority::getAuthority).orElseThrow();

                response.addHeader("Authorization", jwtTokenUtil.generateToken(a.getName(), role));
            } catch (Exception e) {
                exceptionResolver.resolveException(request, response, null, e);
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }

        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath()
                .equals("/login");
    }
}
