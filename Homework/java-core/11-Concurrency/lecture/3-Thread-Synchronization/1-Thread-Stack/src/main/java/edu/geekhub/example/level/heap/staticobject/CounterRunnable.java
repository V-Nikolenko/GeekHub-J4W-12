package edu.geekhub.example.level.heap.staticobject;

public class CounterRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            CountObject.increment();
        }

        String threadName = Thread.currentThread().getName();
        System.out.printf("%s counted up to %s %n", threadName, CountObject.get());
    }
}
