import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transaction {
    private String transactionId;
    private BigDecimal amount;
    private String currency;
    private OffsetDateTime executionTime;

    public Transaction() {
    }

    public Transaction(String transactionId, BigDecimal amount, String currency, OffsetDateTime executionTime) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
        this.executionTime = executionTime;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public OffsetDateTime getExecutionTime() { return executionTime; }
    public void setExecutionTime(OffsetDateTime executionTime) { this.executionTime = executionTime; }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", executionTime=" + executionTime +
                '}';
    }
}