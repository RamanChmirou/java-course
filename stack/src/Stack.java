public class Stack {
    private Node head;
    private int size = 0;

    public Stack(){}

    public void push(int value) {
        head = new Node(value, head);
        size++;
    }

    public Integer pop() {
        if (head == null) {
            System.err.println("Nie ma żadnego elemetu na stosie");
            return null;
        } else {
            int v = head.getValue();
            head = head.getNext();
            size--;
            return v;
        }
    }

    public int size() {
        return size;
    }

    public void addFirst(int value) {
        if (head == null) {
            this.push(value);
        } else {
            Node dummy = head;
            while (dummy.getNext() != null) {
                dummy = dummy.getNext();
            }
            dummy.setNext(new Node(value, null));
            size++;
        }
    }

    public void remove(int value) {
        if (head == null) {
            System.err.println("Nie ma żadnego elemetu na stosie");
            return;
            }
        if (head.getValue() == value) {
            head = head.getNext();
        } else {
            if (head.getNext() == null) {
                System.err.println("Nie ma takiego elemetu na stosie");
                return;
            }
            Node dummy = head;
            while (dummy.getNext().getValue() != value) {
                dummy = dummy.getNext();
                if (dummy.getNext() == null) {
                    System.err.println("Nie ma takiego elemetu na stosie");
                    return;
                }
            }
            dummy.getNext().setNext(dummy.getNext().getNext());
        }
        size--;
    }
}
