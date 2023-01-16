package edu.geekhub.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ApplicationStarter {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableImplementation callableInterfaceImplementation = new CallableImplementation();
        Callable<String> anonymousCallable = getAnonymousCallable();
        Callable<String> lambdaCallable = getLambdaCallable();

        FutureTask<String> futureInterface = new FutureTask<>(callableInterfaceImplementation);
        FutureTask<String> futureAnonymous = new FutureTask<>(anonymousCallable);
        FutureTask<String> futureLambda = new FutureTask<>(lambdaCallable);


        Thread threadInterface = new Thread(futureInterface);
        Thread threadAnonymous = new Thread(futureAnonymous);
        Thread threadLambda = new Thread(futureLambda);

        threadInterface.start();
        threadAnonymous.start();
        threadLambda.start();

        // ToDo String interfaceResult = futureInterface.get(200, TimeUnit.MILLISECONDS);
        String interfaceResult = futureInterface.get();
        String anonymousResult = futureAnonymous.get();
        String lambdaResult = futureLambda.get();

        System.out.println(interfaceResult);
        System.out.println(anonymousResult);
        System.out.println(lambdaResult);
    }

    private static Callable<String> getAnonymousCallable() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Successfully finished anonymous callable";
            }
        };
    }

    private static Callable<String> getLambdaCallable() {
        return () -> "Successfully finished lambda callable";
    }
}
