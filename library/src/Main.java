import Controller.LibraryController;
import Exceptions.ItemAlreadyExistsException;

public class Main {
    public static void main(String[] args) throws ItemAlreadyExistsException {
        LibraryController libraryInterface = new LibraryController();
        libraryInterface.addTestData();
        libraryInterface.start();
    }
}
