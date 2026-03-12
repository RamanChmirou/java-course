package service;

import entity.LibraryItem;
import exception.ItemAlreadyAvailableException;
import exception.ItemAlreadyExistsException;
import exception.ItemAlreadyNotAvailableException;
import exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record LibraryService(List<LibraryItem> items) {
    public Optional<LibraryItem> findByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public void addItem(LibraryItem addedItem) throws ItemAlreadyExistsException {
        Optional<LibraryItem> item = findByTitle(addedItem.getTitle());
        if (item.isPresent()) {
            throw new ItemAlreadyExistsException("Przedmiot już istnieje.");
        }
        items.add(addedItem);
    }

    public void borrowItem(String title) throws ItemNotFoundException {
        Optional<LibraryItem> itemOptional = findByTitle(title);
        LibraryItem item = itemOptional.orElseThrow(() -> new ItemNotFoundException("\"Przedmiot jeszcze nie istnieje.\""));
        if (!item.isAvailable()) {
            throw new ItemAlreadyNotAvailableException("Przedmiot nie jest dostępny.");
        }
        item.setIsAvailable(false);
    }

    public void returnItem(String title) throws ItemNotFoundException {
        Optional<LibraryItem> itemOptional = findByTitle(title);
        LibraryItem item = itemOptional.orElseThrow(() -> new ItemNotFoundException("\"Przedmiot jeszcze nie istnieje.\""));
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
