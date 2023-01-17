package edu.geekhub.example.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {

    private AtomicInteger count = new AtomicInteger(0);

    public void run()
    {
        for (int i = 0; i < 1_000_000; i++) {
            count.addAndGet(1);;
        }
    }

    public int getCount() {
        return count.get();
    }
}
