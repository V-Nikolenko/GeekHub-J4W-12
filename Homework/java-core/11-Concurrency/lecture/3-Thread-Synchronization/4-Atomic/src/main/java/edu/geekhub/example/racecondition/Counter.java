package edu.geekhub.example.racecondition;

public class Counter implements Runnable {

    private int count = 0;

    public void run()
    {
        for (int i = 0; i < 1_000_000; i++) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
