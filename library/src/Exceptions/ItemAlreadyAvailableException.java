package Exceptions;

public class ItemAlreadyAvailableException extends RuntimeException{
    public ItemAlreadyAvailableException(String message) {
    super(message);
}
}
