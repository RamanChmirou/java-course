public class Producer implements Runnable{
    private final MyQueue myQueue;

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 30; i++) {
                Element element = new Element(String.format("Name %d", i));
                myQueue.produce(element);
                int randomTime = (int) (Math.random() * (10000 - 1000) + 1000);
                Thread.sleep(randomTime);
            }
            myQueue.setFinished(true);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
