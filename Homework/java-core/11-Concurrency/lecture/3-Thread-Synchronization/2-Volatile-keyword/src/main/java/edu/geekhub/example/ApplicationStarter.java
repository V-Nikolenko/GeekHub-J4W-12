package edu.geekhub.example;

public class ApplicationStarter {

    private volatile boolean running = true;

    public void test() {
        Runnable processRunnable = () -> {
            int count = 0;
            while (running) {
                count++;
            }
            System.out.println("Thread 1 finished. Counted up to " + count);
        };

        Runnable printer = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {}
            System.out.println("Thread 2 finishing");
            running = false;
        };

        new Thread(processRunnable).start();
        new Thread(printer).start();
    }

    public static void main(String[] args) {
        new ApplicationStarter().test();
    }
}
