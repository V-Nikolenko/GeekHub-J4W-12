package edu.geekhub.lecture.mocking.example4.verifying;

import edu.geekhub.lecture.mocking.BannedUsersClient;
import edu.geekhub.lecture.mocking.ContactInformation;
import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.UserRegistrationService;
import edu.geekhub.lecture.mocking.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VerifyExampleTest {

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
    void verify_method_call() {
        userRegistrationService.forgotUser(User.createEmpty());

        verify(userRepository).delete(any(User.class));
    }

    @Test
    void verify_no_interactions() {
        when(bannedUsersClient.isBanned(anyString(), any()))
            .thenReturn(true);

        assertThatCode(() -> userRegistrationService.registerUser(
            "",
            new ContactInformation("", null))
        ).isInstanceOf(IllegalArgumentException.class);

        verifyNoInteractions(userRepository);
    }
}
