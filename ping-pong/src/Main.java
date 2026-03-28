import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args){
        Thread ping = new Thread(new MyThread("PING"));
        Thread pong = new Thread(new MyThread("PONG"));
        ping.start();
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pong.start();
    }
}
