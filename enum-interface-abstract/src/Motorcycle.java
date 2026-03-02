public class Motorcycle extends Vehicle{
    public Motorcycle(String brand, String model, int year, FuelType fuelType, double capacity, double maxCapacity, double fuelConsumption) {
        super(brand, model, year, fuelType, capacity, maxCapacity, fuelConsumption);

    }
    public String toString() {
        return String.format("brand: %s, model: %s, year: %d, fuelType: %s, capacity: %.2f, maxCapacity: %.2f, fuelConsumption %.2f",
                brand, model, year, fuelType.getName(), capacity, maxCapacity, fuelConsumption);
    }

    public void displayInfo() {
        System.out.println(this);
    }
}
