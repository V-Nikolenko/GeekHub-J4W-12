package edu.geekhub.example.level.stack.field;

public class CounterRunnable implements Runnable {

    @Override
    public void run() {
        int count = 0;

        for (int i = 0; i < 1000; i++) {
            count++;
        }

        String threadName = Thread.currentThread().getName();
        System.out.printf("%s counted up to %s %n", threadName, count);
    }
}
