package edu.geekhub.lecture.mocking.example5.capturing;

import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ArgumentCaptureExampleTest {

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Mock
    private UserRepository userRepository;

    @Test
    void capture_user_argument() {

    }
}
