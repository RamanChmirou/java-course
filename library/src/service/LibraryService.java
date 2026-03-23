package service;

import entity.LibraryItem;
import exception.ItemAlreadyAvailableException;
import exception.ItemAlreadyExistsException;
import exception.ItemAlreadyNotAvailableException;
import exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public record LibraryService(List<LibraryItem> items) {
    public Optional<LibraryItem> findByTitle(String title) {
        return items.stream()
                .filter(t -> t.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public void addItem(LibraryItem addedItem) throws ItemAlreadyExistsException {
        Optional<LibraryItem> item = findByTitle(addedItem.getTitle());
        if (item.isPresent()) {
            throw new ItemAlreadyExistsException("Przedmiot już istnieje.");
        }
        items.add(addedItem);
    }

    public void borrowItem(String title) throws ItemNotFoundException {
        LibraryItem item = findByTitle(title).orElseThrow(() -> new ItemNotFoundException("\"Przedmiot jeszcze nie istnieje.\""));
        if (!item.isAvailable()) {
            throw new ItemAlreadyNotAvailableException("Przedmiot nie jest dostępny.");
        }
        item.setIsAvailable(false);
    }

    public void returnItem(String title) throws ItemNotFoundException {
        LibraryItem item = findByTitle(title).orElseThrow(() -> new ItemNotFoundException("\"Przedmiot jeszcze nie istnieje.\""));
        if (item.isAvailable()) {
            throw new ItemAlreadyAvailableException("Przedmiot już jest dostępny, a z powodu tego że nie mamy kopji, nie mozesz zwracać tego przedmiotu.");
        }
        item.setIsAvailable(true);
    }

    public List<LibraryItem> listAvailableItems() {
        return items.stream()
                .filter(LibraryItem::isAvailable)
                .toList();
    }
}
