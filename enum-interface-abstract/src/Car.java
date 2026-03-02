public class Car extends Vehicle{
    int doors;

    public Car(String brand, String model, int year, FuelType fuelType, double capacity, double maxCapacity, double fuelConsumption, int doors) {
        super(brand, model, year, fuelType, capacity, maxCapacity, fuelConsumption);
        this.doors = doors;
    }

    public String toString() {
        return String.format("brand: %s, model: %s, year: %d, fuelType: %s, capacity: %.2f, maxCapacity: %.2f, fuelConsumption %.2f, doors: %d",
                brand, model, year, fuelType.getName(), capacity, maxCapacity, fuelConsumption, doors);
    }

    public void displayInfo() {
        System.out.println(this);
    }
}
