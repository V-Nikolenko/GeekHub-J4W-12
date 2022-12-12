package org.example.optional;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        Optional<Double> average = average();
        Optional<Double> average1 = average(1, 2, 3, 4, 5);
        average.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
        average1.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0)
            return Optional.empty();
        int sum = 0;
        for (int score : scores)
            sum += score;
        return Optional.of((double) sum / scores.length);
    }
}
