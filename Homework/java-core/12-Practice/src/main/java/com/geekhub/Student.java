package com.geekhub;

public class Student {
    public static int COUNTER = 1;

    private final int id;
    private final String firstName;
    private final String lastName;

    public Student(String firstName, String lastName) {
        this.id = COUNTER++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
