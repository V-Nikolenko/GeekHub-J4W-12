package edu.geekhub.lecture.mocking;

import java.util.ArrayList;
import java.util.List;

import static edu.geekhub.lecture.mocking.util.LectureUtil.sleepSeconds;

public class InMemoryUserRepository implements UserRepository {

    private final List<User> users;

    public InMemoryUserRepository() {
        users = new ArrayList<>();
    }

    @Override
    public User findByUsername(String username) {
        System.out.println("Retrieving a given user from the slow memory storage");

        sleepSeconds(5);

        return null;
    }

    @Override
    public User save(User user) {
        System.out.println("Storing user in the slow memory storage");
        sleepSeconds(5);

        var userToSave = user.withId(calculateNextUserId());

        users.add(userToSave);

        return userToSave;
    }

    private int calculateNextUserId() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

}
