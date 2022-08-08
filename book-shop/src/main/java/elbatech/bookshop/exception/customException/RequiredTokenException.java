package elbatech.bookshop.exception.customException;

public class RequiredTokenException extends RuntimeException {

    public RequiredTokenException() {
    }

    public RequiredTokenException(String message) {
        super(message);
    }
}
