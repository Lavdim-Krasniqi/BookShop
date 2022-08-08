package elbatech.bookshop.exception;

public class RequiredTokenException extends RuntimeException {

    public RequiredTokenException() {
    }

    public RequiredTokenException(String message) {
        super(message);
    }
}
