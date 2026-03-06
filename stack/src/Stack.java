public class Stack <T>{
    private Node<T> head;
    private int size = 0;

    public Stack(){}

    public void push(T value) {
        head = new Node<>(value, head);
        size++;
    }

    public T pop() {
        if (head == null) {
            System.err.println("Nie ma żadnego elemetu na stosie");
            return null;
        }
        T v = head.getValue();
        head = head.getNext();
        size--;
        return v;
    }

    public int size() {
        return size;
    }

    public void addFirst(T value) {
        if (head == null) {
            this.push(value);
        } else {
            Node<T> dummy = head;
            while (dummy.getNext() != null) {
                dummy = dummy.getNext();
            }
            dummy.setNext(new Node<>(value, null));
            size++;
        }
    }

    public void remove(T value) {
        if (head == null) {
            System.err.println("Nie ma żadnego elemetu na stosie");
            return;
        }

        if (head.getValue().equals(value)) {
            head = head.getNext();
            size--;
            return;
        }

        Node<T> dummy = head;
        while (dummy.getNext() != null) {
            if (dummy.getNext().getValue().equals(value)) {
                dummy.setNext(dummy.getNext().getNext());
                size--;
                return;
            }
            dummy = dummy.getNext();
        }
    }
}
