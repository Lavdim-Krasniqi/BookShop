package elbatech.bookshop.security.authentication.filters;

import elbatech.bookshop.exception.customException.RequiredTokenException;
import elbatech.bookshop.security.authentication.providers.TokenAuthentication;
import elbatech.bookshop.security.authentication.utility.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver exceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token == null) {
            if (request.getServletPath().equals("/user/addUser")) {
                filterChain.doFilter(request, response);
                return;
            }
            exceptionResolver.resolveException(request, response, null, new RequiredTokenException("Token shouldn't be null"));
        } else {
            val authentication = new TokenAuthentication(token, null);
            try {
                Authentication a = manager.authenticate(authentication);
                SecurityContextHolder.getContext().setAuthentication(a);
                filterChain.doFilter(request, response);
            } catch (BadCredentialsException e) {
                exceptionResolver.resolveException(request, response, null, e);
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            } catch (ExpiredJwtException e){
                exceptionResolver.resolveException(request, response, null, e);
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().equals("/login");
    }
}
