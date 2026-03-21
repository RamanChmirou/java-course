import exceptions.HistoryOverFlowException;
import exceptions.WrongNumberFormatException;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MobilePhone extends Phone {
    protected final List<String> callHistory = new ArrayList<>();

    public MobilePhone(String communicationInterface, Color color) {
        super(communicationInterface, color);
    }

    @Override
    public void call(String number) throws WrongNumberFormatException {
        super.call(number);
        if (callHistory.size() >= 10) {
            throw new HistoryOverFlowException("Historia polączeń już pełna.");
        }
        callHistory.add(number);
    }

    @Override
    public void showCallHistory() {
        callHistory.forEach(System.out::println);
    }
}
