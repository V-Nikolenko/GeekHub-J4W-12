package edu.geekhub.example.fix;

public class Counter implements Runnable {

    private volatile int count = 0;

    public synchronized void run()
    {
        for (int i = 0; i < 1_000_000; i++) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
