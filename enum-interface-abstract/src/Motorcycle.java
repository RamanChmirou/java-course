public class Motorcycle extends Vehicle implements Drivable{
    public Motorcycle(String brand, String model, int year, FuelType fuelType, double capacity, double maxCapacity) {
        super(brand, model, year, fuelType, capacity, maxCapacity);
    }
    public String toString() {
        return String.format("%s, %s, %d, %s, %.2f, %.2f", brand, model, year, fuelType.getName(), capacity, maxCapacity);
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }

    public void drive(long distance) {
        if (capacity - distance * fuelType.getUnitPerDistance() <= 0) {
            long permissibleDistance = (long) (capacity / fuelType.getUnitPerDistance());
            System.out.printf("przejechałes tylko %d", permissibleDistance);
            System.out.println();
            capacity = 0;
        } else {
            capacity -= distance * fuelType.getUnitPerDistance();
        }
    }
}
