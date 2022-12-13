package edu.geekhub.lecture.mocking.example3.stubbing.doubletypes;

import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRepository;

import java.time.LocalDate;

/**
 * A <strong>mock</strong> is a combination of stub and spy, i.e., a test double that allows you to control the data it
 * returns
 * while also recording the calls made to it so that you can check that it was called with the correct parameters.
 */
public class MockUserRepository implements UserRepository {

    private int methodInvocationCount;

    public MockUserRepository() {
        this.methodInvocationCount = 0;
    }

    @Override
    public User findByUsername(String username) {
        methodInvocationCount++;

        if (username == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (username.equals("batman")) {
            return new User(
                1,
                "Batman",
                "bruce.wayne@dc.com",
                LocalDate.now()
            );
        }

        return User.createEmpty();
    }

    @Override
    public User save(User user) {
        methodInvocationCount++;

        return User.createEmpty();
    }

    @Override
    public void delete(User user) {
        methodInvocationCount++;

        if (user == null) {
            throw new IllegalArgumentException("Cant delete null user");
        }
    }
}
