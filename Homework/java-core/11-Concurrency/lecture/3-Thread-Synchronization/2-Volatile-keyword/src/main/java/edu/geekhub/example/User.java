package edu.geekhub.example;

public class User {

    private String firstName;
    private String lastName;
    private volatile boolean isChanged;

    public void change() {
        firstName= "dasd";
        lastName = "sdaa";
        isChanged = true;
    }

    public void get() {
        this.isChanged;
        String firstName;
        String lastName;
    }

}
