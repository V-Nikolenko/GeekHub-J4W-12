package edu.geekhub.example;

public class ApplicationStarter {

    public static void main(String[] args) {
        Runnable anonymousClass = new Runnable() {
            @Override
            public void run() {
                System.out.println("[3-Implement-Runnable-As-Anonymous-Class] Executing anonymous runnable implementation");
            }
        };

        Thread thread = new Thread(anonymousClass);
        thread.start();
    }
}
