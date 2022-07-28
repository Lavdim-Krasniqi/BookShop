package elbatech.bookshop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
public class ApiExceptionHandler implements Cloneable, Serializable {

    private Date timestamp;
    private Integer status;
    private HttpStatus error;
    private String message;


}
