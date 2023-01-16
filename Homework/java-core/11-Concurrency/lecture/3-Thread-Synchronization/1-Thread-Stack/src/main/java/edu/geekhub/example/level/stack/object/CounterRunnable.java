package edu.geekhub.example.level.stack.object;

public class CounterRunnable implements Runnable {

    @Override
    public void run() {
        CountObject countObject = new CountObject();

        for (int i = 0; i < 1000; i++) {
            countObject.increment();
        }

        String threadName = Thread.currentThread().getName();
        System.out.printf("%s counted up to %s in %s %n", threadName, countObject.get(), countObject);
    }
}
