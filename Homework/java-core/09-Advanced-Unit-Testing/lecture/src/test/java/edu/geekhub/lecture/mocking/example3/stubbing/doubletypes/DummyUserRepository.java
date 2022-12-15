package edu.geekhub.lecture.mocking.example3.stubbing.doubletypes;

import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRepository;

/**
 *
 * A <strong>dummy</strong> is a test double that throws an exception when a method on it is invoked.
 */
public class DummyUserRepository implements UserRepository {
    @Override
    public User findByUsername(String username) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User save(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException();
    }
}
