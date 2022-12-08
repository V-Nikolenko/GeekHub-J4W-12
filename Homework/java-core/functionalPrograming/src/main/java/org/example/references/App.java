package org.example.references;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
        messages.forEach(System.out::println);

        System.out.println("---------------------------");

        messages.forEach(System.out::println);
    }
}
