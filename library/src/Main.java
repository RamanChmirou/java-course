import Exceptions.ItemAlreadyExistsException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ItemAlreadyExistsException {
        LibraryInterface libraryInterface = new LibraryInterface();
        boolean continueProgram = true;
        Scanner scanner = new Scanner(System.in);
        libraryInterface.addTestData();

        libraryInterface.sayHello();
        String answer;
        while (continueProgram) {
            libraryInterface.showOptions();
            answer = scanner.nextLine();
            switch (answer) {
                case "1" -> libraryInterface.showItemsAvailability();
                case "2" -> libraryInterface.borrowItem();
                case "3" -> libraryInterface.returnItem();
                case "4" -> libraryInterface.showItemsQuantity();
                case "5" -> continueProgram = false;
                default -> System.out.println("Nie ma takiej opcji\n");
            }
        }
        libraryInterface.sayBye();
    }
}
