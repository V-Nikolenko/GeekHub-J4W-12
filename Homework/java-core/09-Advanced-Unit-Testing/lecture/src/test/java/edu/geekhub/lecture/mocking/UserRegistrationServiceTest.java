package edu.geekhub.lecture.mocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserRegistrationServiceTest {

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BannedUsersClient bannedUsersClient;

    private UserRegistrationService userRegistrationService;

    @BeforeEach
    void setUp() {
        userRegistrationService = new UserRegistrationService(
            userRepository,
            bannedUsersClient
        );
    }

    @Test
    void check_argument_capturing() {
        userRegistrationService.registerUser(
            "bruce",
            new ContactInformation(
                null,
                new Address()
            )
        );

        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).extracting(User::email).isEqualTo("bruce@gmail.com");
    }
}
