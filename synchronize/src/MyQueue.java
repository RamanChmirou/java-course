import java.util.LinkedList;
import java.util.List;

public class MyQueue {
    private final List<Element> elements = new LinkedList<>();
    private volatile boolean isFinished;

    public synchronized void produce(Element element) throws InterruptedException {
        while (elements.size() >= 5) {
            wait();
        }
        elements.add(element);
        System.out.printf("Producent dodał %s.%n", element);
        notifyAll();
    }

    public synchronized boolean consume() throws InterruptedException {
        while (elements.isEmpty()) {
            if (isFinished) {
                return false;
            }
            wait();
        }
        Element element = elements.removeFirst();
        System.out.printf("Consument pobrał %s.%n", element);
        notifyAll();
        return true;
    }

    public synchronized void setFinished(boolean finished) {
        isFinished = finished;
        notifyAll();
    }
}
