package edu.geekhub.example.level.stack.object;

public class ApplicationStarter {

    public static void main(String[] args) {
        CounterRunnable counterRunnable = new CounterRunnable();

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
