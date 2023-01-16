package edu.geekhub.example;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final AtomicInteger idCounter = new AtomicInteger(0);

    private final int id;

    public User() {
        this.id = idCounter.getAndIncrement();
    }

    public int getId() {
        return id;
    }
}
