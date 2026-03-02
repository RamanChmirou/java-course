public class Car extends Vehicle implements Drivable {
    int doors;

    public Car(String brand, String model, int year, FuelType fuelType, double capacity, double maxCapacity, int doors) {
        super(brand, model, year, fuelType, capacity, maxCapacity);
        this.doors = doors;
    }

    public String toString() {
        return String.format("%s, %s, %d, %s, %.2f, %.2f, %d", brand, model, year, fuelType.getName(), capacity, maxCapacity, doors);
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
