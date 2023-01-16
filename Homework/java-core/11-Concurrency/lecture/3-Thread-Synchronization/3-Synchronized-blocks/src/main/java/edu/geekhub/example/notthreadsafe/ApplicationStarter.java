package edu.geekhub.example.notthreadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApplicationStarter {

    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable saveNewUser = () -> {
            User newUser = new User();
            users.add(newUser);
        };

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(saveNewUser);
            thread.start();
        }

        Thread.sleep(1000);

        users.stream()
                .map(User::getId)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}
