package edu.geekhub.example.threadsafe;

public class User {

    private static volatile int idCounter = 0;

    private final int id;

    public User() {
        this.id = getAndIncrement();
    }

    public synchronized int getAndIncrement() {
        return idCounter++;
    }

    public int getId() {
        return id;
    }
}
