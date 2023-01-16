package edu.geekhub.example;

public class CustomThread extends Thread {

    @Override
    public void run() {
        System.out.println("[1-Extend-Thread-Class] Executing process in a custom thread");
    }
}