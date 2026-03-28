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
                int randomTime = (int) (Math.random() * (100 - 50) + 50);
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
