import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Smartphone extends MobilePhone {
    private final List<Person> listOfFriends= new ArrayList<>();

    public Smartphone(String communicationInterface, Color color) {
        super(communicationInterface, color);
    }

    public void addPerson(Person person) {
        listOfFriends.add(person);
    }

    @Override
    public void showCallHistory() {
        callHistory.forEach(call -> {
            Optional<Person> foundPerson = listOfFriends.stream()
                    .filter(person -> person.getNumber().equals(call))
                    .findFirst();
            foundPerson.ifPresentOrElse(
                    person -> System.out.println(person.getFirstName() + " " + person.getLastName() + person.getNumber()),
                    () -> System.out.println(call)
            );
        });
    }
}
