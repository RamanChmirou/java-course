import java.math.BigDecimal;

public abstract class Vehicle implements Drivable{
    String brand;
    String model;
    int year;
    FuelType fuelType;
    double capacity;
    double maxCapacity;
    double fuelConsumption;

    public Vehicle (String brand, String model, int year, FuelType fuelType, double capacity, double maxCapacity, double fuelConsumption) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.capacity = capacity;
        this.maxCapacity = maxCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public abstract void displayInfo();

    public void refuel(double amount) {
        if (capacity + amount > maxCapacity) {
            capacity = maxCapacity;
            System.out.println("Za dużo paliwa");
        } else {
            capacity += amount;
        }
        System.out.printf("Cena paliwa: %.2f\n", fuelType.getPricePerUnit().multiply(BigDecimal.valueOf(amount)));
    }

    public void drive(long distance) {
        if (capacity - distance * fuelConsumption <= 0) {
            long permissibleDistance = (long) (capacity / fuelConsumption);
            System.out.printf("przejechałes tylko %d", permissibleDistance);
            System.out.println();
            capacity = 0;
        } else {
            capacity -= distance * fuelConsumption;
        }
    }
}
