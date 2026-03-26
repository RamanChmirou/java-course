public class Consumer implements Runnable {
    private final MyQueue myQueue;

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!myQueue.consume()) {
                    break;
                }
                int randomTime = (int) (Math.random() * (10000 - 5000) + 5000);
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
