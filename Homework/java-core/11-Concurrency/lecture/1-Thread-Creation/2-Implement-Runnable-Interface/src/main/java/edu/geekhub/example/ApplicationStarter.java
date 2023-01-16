package edu.geekhub.example;

public class ApplicationStarter {

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableImplementation());
        thread.start();
    }
}
