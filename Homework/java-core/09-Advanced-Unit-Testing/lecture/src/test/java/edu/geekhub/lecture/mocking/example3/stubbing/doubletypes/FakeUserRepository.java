package edu.geekhub.lecture.mocking.example3.stubbing.doubletypes;

import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRepository;
import edu.geekhub.lecture.mocking.util.LectureUtil;

import java.time.LocalDate;

/**
 * A <strong>fake</strong> is a test double that has the same business-logic behavior as the real component it’s doubling,
 * but using a simplified implementation. Because it has behavior, fakes must themselves be tested, and ideally,
 * tested using the same test cases as those used for the real component.
 */
public class FakeUserRepository implements UserRepository {
    @Override
    public User findByUsername(String username) {
        System.out.println("User with username: " + username + " was found");
        return new User(
            LectureUtil.randomNumber(),
            LectureUtil.randomAlphabeticString(),
            LectureUtil.randomAlphabeticString(),
            LocalDate.now()
        );
    }

    @Override
    public User save(User user) {
        System.out.println("User: " + user + " was saved");

        return new User(
            LectureUtil.randomNumber(),
            LectureUtil.randomAlphabeticString(),
            LectureUtil.randomAlphabeticString(),
            LocalDate.now()
        );
    }

    @Override
    public void delete(User user) {
        System.out.println("User: " + user + " was deleted");
    }
}
