package edu.geekhub.example;

import static java.lang.String.format;

public class ApplicationStarter {

    public static void main(String[] args) {
        Runnable customRunnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.printf("Executing %s thread%n", threadName);
        };

        Thread thread1 = new Thread(customRunnable, "FirstThreadName");
        thread1.start();

        Thread thread2 = new Thread(customRunnable, "SecondThreadName");
        thread2.start();
    }
}
