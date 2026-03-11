package Exceptions;

public class ItemAlreadyNotAvailableException extends RuntimeException{
    public ItemAlreadyNotAvailableException(String message) {
        super(message);
    }
}
