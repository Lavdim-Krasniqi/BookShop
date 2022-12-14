package elbatech.bookshop.exception.exceptionHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import elbatech.bookshop.exception.ApiExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {

        response.setContentType("application/json");

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ApiExceptionHandler exceptionHandler =
                new ApiExceptionHandler(new Date(), HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED, e.getMessage());
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, exceptionHandler);
        out.flush();
    }
}