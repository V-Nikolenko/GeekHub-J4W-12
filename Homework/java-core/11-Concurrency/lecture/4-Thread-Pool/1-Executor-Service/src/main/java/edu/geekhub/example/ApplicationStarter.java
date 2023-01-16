package edu.geekhub.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ApplicationStarter {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Initialization
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

        // Running threads
        Future<String> callableSubmitResponse = fixedThreadPool.submit(new CallableImplementation());

        Future<?> runnableSubmitResponse = fixedThreadPool.submit(new RunnableImplementation());

        fixedThreadPool.execute(new RunnableImplementation());

        // Shutdown
        fixedThreadPool.shutdown();

        fixedThreadPool.shutdownNow();

//        callableSubmitResponse.cancel(true);

        System.out.println(callableSubmitResponse.get());
        System.out.println(runnableSubmitResponse.get());
    }
}
