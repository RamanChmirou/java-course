import java.math.BigDecimal;

public enum FuelType {
    PETROL("Petrol", BigDecimal.valueOf(1000)),
    DISEL("Disel", BigDecimal.valueOf(2000)),
    ELECTRIC("Electric", BigDecimal.valueOf(3000));
    private final String name;
    private final BigDecimal pricePerUnit;

    FuelType(String name, BigDecimal cena) {
        this.name = name;
        this.pricePerUnit = cena;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public String getName() {
        return name;
    }
}
