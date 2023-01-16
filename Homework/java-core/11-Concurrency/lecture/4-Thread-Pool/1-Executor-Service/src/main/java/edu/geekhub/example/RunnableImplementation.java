package edu.geekhub.example;

public class RunnableImplementation implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s runnable finished%n", threadName);
    }
}
