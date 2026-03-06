public class Node <T>{
    private final T value;
    private Node<T> next;

    public Node(T value, Node<T> node) {
        this.value = value;
        this.next = node;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
