package edu.geekhub.example;

public class ApplicationStarter {

    public static void main(String[] args) {
        Runnable processLogic = getRunnable();
        Runnable yieldProcessLogic = getYieldRunnable();

        Thread process1 = new Thread(yieldProcessLogic, "first process");
        Thread process2 = new Thread(processLogic, "second process");
        Thread process3 = new Thread(yieldProcessLogic, "third process");

        process1.start();
        process2.start();
        process3.start();

    }

    private static Runnable getYieldRunnable() {
        return () -> {
            for (int i = 0; i < 5; ++i) {
                Thread.yield();
                System.out.printf("Running %s with %s priority. %n",
                        Thread.currentThread().getName(),
                        Thread.currentThread().getPriority());
            }
        };
    }

    private static Runnable getRunnable() {
        return () -> {
            for (int i = 0; i < 5; ++i) {
                System.out.printf("Running %s with %s priority. %n",
                        Thread.currentThread().getName(),
                        Thread.currentThread().getPriority()
                );
            }
        };
    }
}