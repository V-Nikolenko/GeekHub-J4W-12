package edu.geekhub.example;

public class ApplicationStarter {

    public static void main(String[] args) throws InterruptedException {
        String mainThreadName = Thread.currentThread().getName();
        System.out.printf("%s thread is started.%n", mainThreadName);

        Runnable unstoppableRunnable = () -> {
            while (true) {
                try {
                    String subThreadName = Thread.currentThread().getName();
                    System.out.printf("%s thread is running.%n%n", subThreadName);
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        };

        Thread unstoppableThread = new Thread(unstoppableRunnable, "Sub Thread");
        unstoppableThread.setDaemon(false);
        unstoppableThread.start();

        System.out.printf("%s thread is paused for 5 seconds.%n", mainThreadName);
        Thread.sleep(5000);
        System.out.printf("%s thread is terminated.%n", mainThreadName);
    }
}
