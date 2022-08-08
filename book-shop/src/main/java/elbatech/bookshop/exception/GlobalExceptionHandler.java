package elbatech.bookshop.exception;

import elbatech.bookshop.exception.customException.RequiredTokenException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException e) {
        ApiExceptionHandler exceptionHandler =
                new ApiExceptionHandler(new Date(), HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN, e.getMessage());
        return new ResponseEntity<>(exceptionHandler, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException e) {
        ApiExceptionHandler exceptionHandler =
                new ApiExceptionHandler(new Date(), HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN, e.getMessage());
        return new ResponseEntity<>(exceptionHandler, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(value = {SignatureException.class})
    public ResponseEntity<Object> handleExpiredJwtException(SignatureException ex, WebRequest request) {
        ApiExceptionHandler exceptionMessage =
                new ApiExceptionHandler(new Date(), HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN, ex.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        ApiExceptionHandler exceptionMessage =
                new ApiExceptionHandler(new Date(), HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED, ex.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        ApiExceptionHandler exceptionMessage =
                new ApiExceptionHandler(new Date(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {RequiredTokenException.class})
    public ResponseEntity<Object> requiredTokenException(RequiredTokenException ex, WebRequest request) {
        ApiExceptionHandler exceptionMessage =
                new ApiExceptionHandler(new Date(),
                        HttpStatus.FORBIDDEN.value(),
                        HttpStatus.FORBIDDEN, ex.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.FORBIDDEN);
    }


}
