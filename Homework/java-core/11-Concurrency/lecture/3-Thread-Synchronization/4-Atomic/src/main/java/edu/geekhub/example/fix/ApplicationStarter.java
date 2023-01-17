package edu.geekhub.example.fix;

public class ApplicationStarter {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread first = new Thread(counter, "First");
        Thread second = new Thread(counter, "Second");

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(counter.getCount());
    }
}
