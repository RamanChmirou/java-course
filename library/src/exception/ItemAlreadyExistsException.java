package exception;

public class ItemAlreadyExistsException extends Exception{
    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
