package edu.geekhub.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ApplicationStarter {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

//        scheduledExecutor.schedule(new CallableImplementation(), 2000, TimeUnit.MILLISECONDS);
        
        scheduledExecutor.scheduleAtFixedRate(new RunnableImplementation(), 2000, 1000, TimeUnit.MILLISECONDS);
    }
}
