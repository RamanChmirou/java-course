import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Content container = new Content();

        container.personalData = new PersonalData();
        container.personalData.fullName = "Adam Nowak";
        container.personalData.age = 30;

        container.employmentData = new EmploymentData();
        container.employmentData.employees = Arrays.asList(
                new Employee() {{ name = "James Kirk"; age = 40; }},
                new Employee() {{ name = "Jean-Luc Picard"; age = 45; }}
        );

        container.orderData = new OrderData();
        container.orderData.lastUpdatedAt = "2023-06-01T10:15:30";

        Order order = new Order();
        order.orderNumber = 78787;
        order.createdAt = "2024-02-28T09:30:00";

        Item item = new Item();
        item.name = "Laptop";
        item.quantity = 1;
        item.price = 2499.99;
        order.items = Arrays.asList(item);

        order.shipmentAddress = new ShipmentAddress();
        order.shipmentAddress.street = "Kwiatowa 15";
        order.shipmentAddress.city = "Warszawa";
        order.shipmentAddress.postalCode = "00-001";
        order.shipmentAddress.country = "Polska";

        container.orderData.orders = Arrays.asList(order);
    }
}
