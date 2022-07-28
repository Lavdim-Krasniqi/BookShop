package elbatech.bookshop.security.authorization;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MethodAuthorization {

    public boolean hasAuthority(String authority) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String role = authentication.getAuthorities()
                .stream()
                .findFirst().orElseThrow().getAuthority();

        ApplicationUserRole applicationUserRole = ApplicationUserRole.valueOf(role);

        return applicationUserRole.getAuthorities()
                .stream().anyMatch(simpleGrantedAuthority -> simpleGrantedAuthority.getAuthority().equals(authority));
    }

    public boolean hasRole(String role) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getAuthorities()
                .stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));
    }
}
