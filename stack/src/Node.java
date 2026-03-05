public class Node {
    private final int value;
    private Node next;

    public Node(int value, Node node) {
        this.value = value;
        this.next = node;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
