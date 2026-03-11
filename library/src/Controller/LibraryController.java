package Controller;

import Entity.Book;
import Entity.LibraryItem;
import Entity.Movie;
import Exceptions.ItemAlreadyAvailableException;
import Exceptions.ItemAlreadyExistsException;
import Exceptions.ItemAlreadyNotAvailableException;
import Exceptions.ItemNotFoundException;
import Service.LibraryService;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryController {
    private static final LibraryService library = new LibraryService(new ArrayList<>());
    private static final Scanner scanner = new Scanner(System.in);

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


    public void start() {
        boolean continueProgram = true;
        sayHello();
        String answer;
        while (continueProgram) {
            showOptions();
            answer = scanner.nextLine();
            try {
                switch (answer) {
                    case "1" -> showItemsAvailability();
                    case "2" -> borrowItem();
                    case "3" -> returnItem();
                    case "4" -> showItemsQuantity();
                    case "5" -> continueProgram = false;
                    default -> System.out.println("Nie ma takiej opcji\n");
                }
            } catch (ItemAlreadyNotAvailableException | ItemAlreadyAvailableException | ItemNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }
        sayBye();
    }

    public static void sayHello() {
        System.out.println("Siema, co chcesz zrobić?");
    }

    public static void sayBye() {
        System.out.println("Na razie.");
    }

    public static void showOptions() {
        System.out.print("""
                1) Wyświetlij listę dostępnych i wypożyczonych przedmiotów
                2) Wyporzycz przedmiot
                3) Zwróć przedmiot
                4) Pokaż ilość przedmiotów
                5) Koniec działania
                """);
    }

    public static void borrowItem() throws ItemNotFoundException {
        if (library.listAvailableItems().isEmpty()) {
            System.out.println("Nie ma żadnego przedmiotu do wypożyczenia.");
            return;
        }
        System.out.println("Co chcesz wypożyczyć, książkę(k) czy filmik(f)?");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("k") || answer.equalsIgnoreCase("f")) {
            System.out.println("Podaj tytuł");
            String title = scanner.nextLine();
            library.borrowItem(title);
            System.out.println("Pomyślnie wypożyczono przedmiot: " + title);
        } else {
            System.out.println("Tego nie możesz wypożyczyć.");
        }
    }

    public static void returnItem() throws ItemNotFoundException {
        if (library.items().size() == library.listAvailableItems().size()) {
            System.out.println("Nie ma żadnego przedmiotu do zwrócenia.");
            return;
        }
        System.out.println("Co chcesz zwrócić, książkę(k) czy filmik(f)?");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("k") || answer.equalsIgnoreCase("f")) {
            System.out.println("Podaj tytuł");
            String title = scanner.nextLine();
            library.returnItem(title);
            System.out.println("Pomyślnie zwrócono przedmiot: " + title);
        } else {
            System.out.println("Tego nie możesz zwrócić.");
        }
    }

    public static void showItemsAvailability() {
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

    public static void showItemsQuantity() {
        System.out.printf("Liczba książek: %d\nLiczba filmików: %d\n", Book.getNumberOfBooks(), Movie.getNumberOfMovies());
    }
}
