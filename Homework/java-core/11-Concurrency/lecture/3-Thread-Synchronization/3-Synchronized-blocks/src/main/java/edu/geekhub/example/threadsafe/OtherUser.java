package edu.geekhub.example.threadsafe;

public class OtherUser {

    private static volatile int idCounter = 0;

    private final int id;

    public OtherUser() {
        this.id = getAndIncrement();
    }

    public int getAndIncrement() {
        synchronized (this) {
            return idCounter++;
        }
    }

    public int getId() {
        return id;
    }
}
