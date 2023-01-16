package edu.geekhub.example.level.heap.object;

public class CounterRunnable implements Runnable {

    private final CountObject countObject;

    public CounterRunnable(CountObject countObject) {
        this.countObject = countObject;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            countObject.increment();
        }

        String threadName = Thread.currentThread().getName();
        System.out.printf("%s counted up to %s in %s %n", threadName, countObject.get(), countObject);
    }
}
