package edu.geekhub.homework;

import edu.geekhub.models.User;
import edu.geekhub.storage.Repository;

import java.util.ArrayList;
import java.util.List;

// Don't change this class
public final class TestMemoryStorage implements Repository {

    private final List<User> users = new ArrayList<>();

    public void tryToAdd(User user) {
        users.add(user);
    }

    public User[] tryToGetAll() {
        return users.toArray(User[]::new);
    }
}