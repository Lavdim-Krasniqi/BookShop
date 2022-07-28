package elbatech.bookshop.security.authentication.filters;

import elbatech.bookshop.security.authentication.providers.TokenAuthentication;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
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
            filterChain.doFilter(request, response);
        } else {
            val authentication = new TokenAuthentication(token, null);
            try {
                Authentication a = manager.authenticate(authentication);
                SecurityContextHolder.getContext().setAuthentication(a);
                filterChain.doFilter(request, response);
            } catch (Exception e) {
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
