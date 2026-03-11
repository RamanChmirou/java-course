package Service;

import Entity.LibraryItem;
import Exceptions.ItemAlreadyAvailableException;
import Exceptions.ItemAlreadyExistsException;
import Exceptions.ItemAlreadyNotAvailableException;
import Exceptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;

public record LibraryService(List<LibraryItem> items) {
    public LibraryItem findByTitle(String title) throws ItemNotFoundException {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        throw new ItemNotFoundException("Nie ma takiego przedmiotu lub wprowadziłes nie prawidłowy tytuł.");
    }

    public void addItem(LibraryItem addedItem) throws ItemAlreadyExistsException {
        try {
            findByTitle(addedItem.getTitle());
            throw new ItemAlreadyExistsException("Przedmiot już istnieje.");
        } catch (ItemNotFoundException e) {
            items.add(addedItem);
        }
    }

    public void borrowItem(String title) throws ItemAlreadyNotAvailableException, ItemNotFoundException {
        LibraryItem item = findByTitle(title);
        if (item.isAvailable()) {
            item.setIsAvailable(false);
            return;
        }
        throw new ItemAlreadyNotAvailableException("Przedmiot nie jest dostępny.");
    }

    public void returnItem(String title) throws ItemAlreadyAvailableException, ItemNotFoundException {
        LibraryItem item = findByTitle(title);
        if (!item.isAvailable()) {
            item.setIsAvailable(true);
            return;
        }
        throw new ItemAlreadyAvailableException("Przedmiot już jest dostępny, a z powodu tego że nie mamy kopji, nie mozesz zwracać tego przedmiotu.");
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
