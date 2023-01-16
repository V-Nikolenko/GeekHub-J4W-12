package edu.geekhub.example.level.heap.staticobject;

public class CountObject {

    private static int value = 0;

    public static int get() {
        return value;
    }

    public static void increment() {
        value++;
    }
}
