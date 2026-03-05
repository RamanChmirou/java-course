public class Stack {
    private Node head;
    private int size = 0;

    public Stack(){}

    public void push(int value) {
        head = new Node(value, head);
        size++;
    }

    public int pop() {
        int v = head.getValue();
        head = head.getNext();
        size--;
        return v;
    }

    public int size() {
        return size;
    }

    public void addFirst(int value) {
        Node dummy = head;
        while (dummy.getNext() != null) {
            dummy = dummy.getNext();
        }
        dummy.setNext(new Node(value, null));
        size++;
    }

    public void remove(int value) {
        if (head.getValue() == value) {
            head = head.getNext();
        } else if (head.getNext().getValue() == value) {
            head.setNext(head.getNext().getNext());
        } else {
            Node dummy = head;
            while (dummy.getNext().getNext().getValue() != value) {
                dummy = dummy.getNext();
            }
            dummy.getNext().setNext(dummy.getNext().getNext().getNext());
        }
        size--;
    }
}
