package edu.geekhub.lecture.mocking.example3.stubbing.doubletypes;

import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRepository;

/**
 * A <strong>spy</strong> is a test double that records the invocations of its methods,
 * along with any parameters passed in, so that you can find out afterward whether and how its methods were called.
 */
public class SpyUserRepository implements UserRepository {

    private static final User UNSUPPORTED_USER = User.createEmpty();

    private final UserRepository userRepository;
    private int methodInvocationCount;

    public SpyUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.methodInvocationCount = 0;
    }

    @Override
    public User findByUsername(String username) {
        methodInvocationCount++;
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        methodInvocationCount++;
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        methodInvocationCount++;

        if (UNSUPPORTED_USER.equals(user)) {
            throw new IllegalArgumentException("Cant delete unsupported user");
        }

        userRepository.delete(user);
    }


}
