import Exceptions.ItemAlreadyAvailableException;
import Exceptions.ItemAlreadyExistsException;
import Exceptions.ItemAlreadyNotAvailableException;
import Exceptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryInterface {
    private final Library library = new Library(new ArrayList<>());
    private final Scanner scanner = new Scanner(System.in);

    public void addTestData() throws ItemAlreadyExistsException {
        Book book1 = new Book("book1", true, "author1", 354);
        Book book2 = new Book("book2", true, "author1", 502);
        Book book3 = new Book("book3", true, "author2", 1243);
        Movie movie1 = new Movie("movie1", true, "director1", 302);
        Movie movie2 = new Movie("movie2", true, "director2", 230);
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(movie1);
        library.addItem(movie2);
    }

    public void sayHello() {
        System.out.println("Siema, co chcesz zrobić?");
    }

    public void sayBye() {
        System.out.println("Na razie.");
    }

    public void showOptions() {
        System.out.print("""
                1) Wyświetlij listę dostępnych i wypożyczonych przedmiotów
                2) Wyporzycz przedmiot
                3) Zwróć przedmiot
                4) Pokaż ilość przedmiotów
                5) Koniec działania
                """);
    }

    public void borrowItem() {
        if (library.listAvailableItems().isEmpty()) {
            System.out.println("Nie ma żadnego przedmiotu do wypożyczenia.");
            return;
        }
        System.out.println("Co chcesz wypożyczyć, książkę(k) czy filmik(f)?");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("k") || answer.equalsIgnoreCase("f")) {
            System.out.println("Podaj tytuł");
            String title = scanner.nextLine();
            try {
                library.borrowItem(title);
                System.out.println("Pomyślnie wypożyczono przedmiot: " + title);
            } catch (ItemNotFoundException | ItemAlreadyNotAvailableException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Tego nie możesz wypożyczyć.");
        }
    }

    public void returnItem() {
        if (library.items().size() == library.listAvailableItems().size()) {
            System.out.println("Nie ma żadnego przedmiotu do zwrócenia.");
            return;
        }
        System.out.println("Co chcesz zwrócić, książkę(k) czy filmik(f)?");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("k") || answer.equalsIgnoreCase("f")) {
            System.out.println("Podaj tytuł");
            String title = scanner.nextLine();
            try {
                library.returnItem(title);
                System.out.println("Pomyślnie zwrócono przedmiot: " + title);
            } catch (ItemNotFoundException | ItemAlreadyAvailableException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Tego nie możesz zwrócić.");
        }
    }

    public void showItemsAvailability() {
        System.out.println("Wypożyczone:");
        for (LibraryItem item : library.items()) {
            if (!item.isAvailable()) {
                System.out.println(item);
            }
        }
        System.out.println("Dostępne:");
        for (LibraryItem item : library.items()) {
            if (item.isAvailable()) {
                System.out.println(item);
            }
        }
    }

    public void showItemsQuantity() {
        System.out.printf("Liczba książek: %d\nLiczba filmików: %d\n", Book.getNumberOfBooks(), Movie.getNumberOfMovies());
    }
}
