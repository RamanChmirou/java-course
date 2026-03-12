package service;

import entity.LibraryItem;
import exception.ItemAlreadyAvailableException;
import exception.ItemAlreadyExistsException;
import exception.ItemAlreadyNotAvailableException;
import exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;

public record LibraryService(List<LibraryItem> items) {
    public LibraryItem findByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public void addItem(LibraryItem addedItem) throws ItemAlreadyExistsException {
        LibraryItem item = findByTitle(addedItem.getTitle());
        if (item != null) {
            throw new ItemAlreadyExistsException("Przedmiot już istnieje.");
        }
        items.add(addedItem);
    }

    public void borrowItem(String title) throws ItemNotFoundException {
        LibraryItem item = findByTitle(title);
        if (item == null) {
            throw new ItemNotFoundException("Przedmiot jeszcze nie istnieje.");
        }
        if (!item.isAvailable()) {
            throw new ItemAlreadyNotAvailableException("Przedmiot nie jest dostępny.");
        }
        item.setIsAvailable(false);
    }

    public void returnItem(String title) throws ItemNotFoundException {
        LibraryItem item = findByTitle(title);
        if (item == null) {
            throw new ItemNotFoundException("Przedmiot jeszcze nie istnieje.");
        }
        if (item.isAvailable()) {
            throw new ItemAlreadyAvailableException("Przedmiot już jest dostępny, a z powodu tego że nie mamy kopji, nie mozesz zwracać tego przedmiotu.");
        }
        item.setIsAvailable(true);
    }

    public List<LibraryItem> listAvailableItems() {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.isAvailable()) {
                result.add(item);
            }
        }
        return result;
    }
}
