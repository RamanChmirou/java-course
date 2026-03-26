import static java.lang.Thread.sleep;

public class MyThread implements Runnable{
    private final String pingOrPong;

    public MyThread(String pingOrPong) {
        this.pingOrPong = pingOrPong;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(pingOrPong);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
