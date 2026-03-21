import exceptions.WrongNumberFormatException;
import java.awt.Color;

public class Phone {
    private final String communicationInterface;
    private final Color color;

    public Phone(String communicationInterface, Color color) {
        this.communicationInterface = communicationInterface;
        this.color = color;
    }

    public void call(String number) throws WrongNumberFormatException{
        if (numberIsMatchesToFormat(number)) {
            throw new WrongNumberFormatException("Zły format numeru. Może być tylko taki: XXX-XXX-XXX.");
        }
        System.out.printf("Dzwonie pod numer: %s.\n", number);
    }

    private static boolean numberIsMatchesToFormat(String number) {
        return number.matches("\\d{3}-\\d{3}-\\d{3}");
    }

    public void showCallHistory() {
        System.out.println("Brak historji");
    }
}
