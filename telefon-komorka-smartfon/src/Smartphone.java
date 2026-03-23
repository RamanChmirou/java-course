import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Smartphone extends MobilePhone {
    private static final List<Person> listOfFriends= new ArrayList<>();

    public Smartphone(String communicationInterface, Color color) {
        super(communicationInterface, color);
    }

    public void addFriend (Person person) {
        listOfFriends.add(person);
    }

    private static Optional<Person> callIsFriend(String number) {
        return listOfFriends.stream()
                .filter(person -> person.getNumber().equals(number))
                .findFirst();
    }

    @Override
    public void showCallHistory() {
        callHistory.forEach(call ->
            callIsFriend(call).ifPresentOrElse(
                    person -> System.out.printf("%s %s %s\n",
                            person.getFirstName(), person.getLastName(), person.getNumber()),
                    () -> System.out.println(call)
            ));
    }
}
