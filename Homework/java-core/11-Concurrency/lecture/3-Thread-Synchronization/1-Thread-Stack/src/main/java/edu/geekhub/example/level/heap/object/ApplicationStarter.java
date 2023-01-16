package edu.geekhub.example.level.heap.object;

public class ApplicationStarter {

    public static void main(String[] args) {
        CountObject countObject = new CountObject();

        CounterRunnable counterRunnable = new CounterRunnable(countObject);

        Thread firstThread = new Thread(counterRunnable, "FirstThreadName");
        Thread secondThread = new Thread(counterRunnable, "SecondThreadName");

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
