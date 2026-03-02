public enum FuelType {
    PETROL("Petrol", 1000),
    DISEL("Disel", 2000),
    ELECTRIC("Electric", 3000);
    private final String name;
    private final double pricePerUnit;

    FuelType(String name, double cena) {
        this.name = name;
        this.pricePerUnit = cena;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public String getName() {
        return name;
    }
}
