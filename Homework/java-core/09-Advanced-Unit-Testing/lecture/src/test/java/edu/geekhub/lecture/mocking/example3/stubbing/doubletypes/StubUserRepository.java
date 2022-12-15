package edu.geekhub.lecture.mocking.example3.stubbing.doubletypes;

import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRepository;

import java.time.LocalDate;

/**
 * A <strong>stub</strong> is a test double that returns pre-configured, hard-coded data when its methods are called.
 */
public class StubUserRepository implements UserRepository {
    @Override
    public User findByUsername(String username) {
        return new User(
            1,
            "Batman",
            "bruce.wayne@dc.com",
            LocalDate.now()
        );
    }

    @Override
    public User save(User user) {
        return new User(
            1,
            "Batman",
            "bruce.wayne@dc.com",
            LocalDate.now()
        );
    }

    @Override
    public void delete(User user) {
    }
}
