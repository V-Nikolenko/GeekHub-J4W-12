package edu.geekhub.example;

public class ApplicationStarter {

    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();
        customThread.start();
    }
}
