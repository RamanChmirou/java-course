package entity;

public abstract class LibraryItem {
    private final String title;
    private boolean isAvailable;

    public LibraryItem(String title, boolean isAvailable) {
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract String toString();
}
