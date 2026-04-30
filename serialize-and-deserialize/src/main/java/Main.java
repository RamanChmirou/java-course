import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction(
                "TXN-998877",
                new BigDecimal("2500.50"),
                "PLN",
                OffsetDateTime.parse("2026-04-27T17:30:00+02:00")
        );

        String jsonInput = """
                {
                  "transactionId": "TXN-998877",
                  "amount": 2500.50,
                  "currency": "PLN",
                  "executionTime": "2026-04-27T17:30:00+02:00"
                }
                """;

        ObjectMapper basicMapper = new ObjectMapper();

        try {
            basicMapper.writeValueAsString(transaction);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            basicMapper.readValue(jsonInput, Transaction.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        ObjectMapper correctMapper = new ObjectMapper();
        correctMapper.registerModule(new JavaTimeModule());
        correctMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            String generatedJson = correctMapper.writerWithDefaultPrettyPrinter().writeValueAsString(transaction);
            System.out.println(generatedJson);

            Transaction readTransaction = correctMapper.readValue(generatedJson, Transaction.class);
            System.out.println(readTransaction.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}