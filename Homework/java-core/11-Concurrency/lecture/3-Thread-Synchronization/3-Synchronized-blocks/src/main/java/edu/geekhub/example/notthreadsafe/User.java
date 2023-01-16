package edu.geekhub.example.notthreadsafe;

public class User {

    private static int idCounter = 0;

    private final int id;

    public User() {
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }
}
