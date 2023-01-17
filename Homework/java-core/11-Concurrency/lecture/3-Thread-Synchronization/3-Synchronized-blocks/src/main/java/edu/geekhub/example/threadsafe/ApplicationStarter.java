package edu.geekhub.example.threadsafe;

public class ApplicationStarter {

    public static void main(String[] args) {
        Runnable counter = new Counter();
//        Runnable counter = new OtherCounter();

        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}
