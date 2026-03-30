import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue {
    private final List<Element> elements = new LinkedList<>();
    private volatile boolean isFinished;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(Element element) throws InterruptedException {
        lock.lock();
        try {
            while (elements.size() >= 5) {
                notFull.await();
            }
            elements.add(element);
            System.out.printf("Producent dodał %s.%n", element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public boolean consume() throws InterruptedException {
        lock.lock();
        try {
            while (elements.isEmpty()) {
                if (isFinished) {
                    return false;
                }
                notEmpty.await();
            }
            Element element = elements.removeFirst();
            System.out.printf("Consument pobrał %s.%n", element);
            notFull.signalAll();
            return true;
        } finally {
            lock.unlock();
        }
    }

    public synchronized void setFinished(boolean finished) {
        lock.lock();
        try {
            isFinished = finished;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
