public enum FuelType {
    PETROL("Petrol", 1000, 1),
    DISEL("Disel", 2000, 2),
    ELECTRIC("Electric", 3000, 3);
    private final String name;
    private final double pricePerUnit;
    private final double unitPerDistance;

    FuelType(String name, double cena, double unitPerDistance) {
        this.name = name;
        this.pricePerUnit = cena;
        this.unitPerDistance = unitPerDistance;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getUnitPerDistance() {
        return unitPerDistance;
    }
}
