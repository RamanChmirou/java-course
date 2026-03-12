package exception;

public class ItemAlreadyNotAvailableException extends RuntimeException{
    public ItemAlreadyNotAvailableException(String message) {
        super(message);
    }
}
