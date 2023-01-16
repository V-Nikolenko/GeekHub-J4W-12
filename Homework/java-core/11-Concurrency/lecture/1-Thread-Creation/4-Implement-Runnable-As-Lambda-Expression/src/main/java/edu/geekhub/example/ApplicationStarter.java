package edu.geekhub.example;

public class ApplicationStarter {

    public static void main(String[] args) {
        Runnable lambdaExpression = () -> System.out.println("[4-Implement-Runnable-As-Lambda-Expression] Executing lambda expression");

        Thread thread = new Thread(lambdaExpression);
        thread.start();
    }
}
