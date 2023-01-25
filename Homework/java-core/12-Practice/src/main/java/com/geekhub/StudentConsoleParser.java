package com.geekhub;

public class StudentConsoleParser {

    public static Student fromConsoleInput(String input) {
        String[] userData = input.split(",");
        validateUserData(userData);
        return new Student(userData[0], userData[1]);
    }

    private static void validateUserData(String[] userData) {
        if (userData.length != 2) {
            throw new IllegalArgumentException("Invalid console input");
        }
    }
}
