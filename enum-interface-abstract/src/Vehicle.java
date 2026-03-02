public abstract class Vehicle {
    String brand;
    String model;
    int year;
    FuelType fuelType;
    double capacity;
    double maxCapacity;

    public Vehicle (String brand, String model, int year, FuelType fuelType, double capacity, double maxCapacity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.capacity = capacity;
        this.maxCapacity = maxCapacity;
    }

    public Vehicle (){}

    public abstract void displayInfo();

    public void refuel(double amount) {
        if (capacity + amount > maxCapacity) {
            capacity = maxCapacity;
            System.out.println("Za dużo paliwa");
        } else {
            capacity += amount;
        }
    }
}
