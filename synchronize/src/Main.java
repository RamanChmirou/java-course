public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        Thread producer = new Thread(new Producer(myQueue));
        Thread consumer1 = new Thread(new Consumer(myQueue));
        Thread consumer2 = new Thread(new Consumer(myQueue));
        Thread consumer3 = new Thread(new Consumer(myQueue));

        producer.start();
        consumer1.start();
//        consumer2.start();
//        consumer3.start();
    }
}
