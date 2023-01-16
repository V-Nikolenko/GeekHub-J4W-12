package edu.geekhub.example;

import java.util.concurrent.Callable;

public class CallableImplementation implements Callable<String> {

    @Override
    public String call() {
        return "Successfully finished interface callable";
    }
}
