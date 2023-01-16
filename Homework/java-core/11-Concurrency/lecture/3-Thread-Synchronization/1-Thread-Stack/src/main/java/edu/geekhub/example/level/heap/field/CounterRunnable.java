package edu.geekhub.example.level.heap.field;

public class CounterRunnable implements Runnable {

    private long count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }

        String threadName = Thread.currentThread().getName();
        System.out.printf("%s counted up to %s %n", threadName, count);
    }
}
