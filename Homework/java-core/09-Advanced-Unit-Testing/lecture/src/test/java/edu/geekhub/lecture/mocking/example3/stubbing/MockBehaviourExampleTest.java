package edu.geekhub.lecture.mocking.example3.stubbing;

import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRepository;
import edu.geekhub.lecture.mocking.util.LectureUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockBehaviourExampleTest {

    private static final User EXAMPLE_USER = new User(
        LectureUtil.randomNumber(),
        LectureUtil.randomAlphabeticString(),
        LectureUtil.randomAlphabeticString(),
        LocalDate.now()
    );

    @Mock
    private UserRepository userRepository;

    @Test
    void when_then_return() {
        when(userRepository.findByUsername("user"))
            .thenReturn(EXAMPLE_USER);

        var user = userRepository.findByUsername("user");

        assertThat(user).isEqualTo(EXAMPLE_USER);
    }

    @Test
    void when_then_throw() {
        when(userRepository.findByUsername("notFoundUsername"))
            .thenThrow(IllegalArgumentException.class);

        assertThatCode(() -> userRepository.findByUsername("notFoundUsername"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
