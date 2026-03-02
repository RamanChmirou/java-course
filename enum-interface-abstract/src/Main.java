import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Drivable> drivableList = new ArrayList<>();
        Car car1 = new Car("Opel", "Astra", 2007, FuelType.DISEL, 47, 240, 0.6, 4);
        drivableList.add(car1);
        Motorcycle motorcycle1 = new Motorcycle("NieOpel", "NieAstra", 2013, FuelType.PETROL, 60, 200, 0.5);
        drivableList.add(motorcycle1);
        car1.displayInfo();
        motorcycle1.displayInfo();

        for (Drivable d: drivableList) {
            d.drive(20);
        }
        car1.displayInfo();
        motorcycle1.displayInfo();

        car1.refuel(120);
        motorcycle1.refuel(40);
        car1.displayInfo();
        motorcycle1.displayInfo();

        car1.refuel(1000);
        motorcycle1.refuel(1000);

        car1.displayInfo();
        motorcycle1.displayInfo();

        for (Drivable d: drivableList) {
            d.drive(10000);
        }
        car1.displayInfo();
        motorcycle1.displayInfo();
    }
}
