package edu.geekhub.lecture.mocking.example1.introduction;

import edu.geekhub.lecture.mocking.InMemoryUserRepository;
import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRepository;

import java.time.LocalDate;

/**
 * Lets refactor class to make it easier to test
 */
public class SimpleRegistrationService {

    private UserRepository userRepository = new InMemoryUserRepository();

    public User registerUser(String username) {

        User existingUser = userRepository.findByUsername(username);

        if (existingUser != null) {
            return existingUser;
        }

        User user = User.createNewUser(username, LocalDate.now());

        return userRepository.save(user);
    }
}
