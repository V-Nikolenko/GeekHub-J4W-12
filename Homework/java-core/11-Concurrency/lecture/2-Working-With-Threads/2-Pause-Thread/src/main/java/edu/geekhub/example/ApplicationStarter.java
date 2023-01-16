package edu.geekhub.example;

import java.util.Set;

import static java.lang.String.format;

public class ApplicationStarter {

    private static final Set<String> userData = Set.of("First User", "Second User", "Third User", "Fourth User");

    public static void main(String[] args) {
        Runnable processDataRunnable = () -> {
            for (String data : userData) {
                try {
                    System.out.printf("Processing %s data...%n", data);
                    Thread.sleep(2000);
                    System.out.printf("Successfully processed %s data%n%n", data);
                } catch (InterruptedException e) {
                    System.out.printf("Failed to process %s data%n", data);
                }
            }
        };

        Thread processThread = new Thread(processDataRunnable);
        processThread.start();
    }
}
