package exceptions;

public class HistoryOverFlowException extends RuntimeException {
    public HistoryOverFlowException(String message) {
        super(message);
    }
}
