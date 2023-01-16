package edu.geekhub.example;

public class ApplicationStarter {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.printf("%s prints number: %s %n", threadName, i);
            }
        };

        Thread threadOne = new Thread(runnable, "FirstThreadName");
        Thread threadTwo = new Thread(runnable, "SecondThreadName");
        Thread threadThird = new Thread(runnable, "ThirdThreadName");

        threadOne.start();
        threadTwo.start();
        threadThird.start();
    }
}
