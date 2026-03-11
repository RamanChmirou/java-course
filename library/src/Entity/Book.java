package Entity;

public class Book  extends LibraryItem {
    private final String author;
    private final int numberOfPages;
    private static int numberOfBooks;

    public Book(String title, boolean isAvailable, String author, int numberOfPages) {
        super(title, isAvailable);
        this.author = author;
        this.numberOfPages = numberOfPages;
        numberOfBooks++;
    }

    public static int getNumberOfBooks() {
        return numberOfBooks;
    }

    @Override
    public String toString() {
        return String.format("Książka| Tytuł: %s, Autor: %s, Ilość stron: %s", super.getTitle(), author, numberOfPages);
    }
}
