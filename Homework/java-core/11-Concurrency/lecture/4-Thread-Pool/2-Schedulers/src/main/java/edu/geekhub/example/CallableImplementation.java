package edu.geekhub.example;

import java.util.concurrent.Callable;

public class CallableImplementation implements Callable<String> {

    @Override
    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s callable is finished%n", threadName);

        return "All data migrated successfully";
    }
}
