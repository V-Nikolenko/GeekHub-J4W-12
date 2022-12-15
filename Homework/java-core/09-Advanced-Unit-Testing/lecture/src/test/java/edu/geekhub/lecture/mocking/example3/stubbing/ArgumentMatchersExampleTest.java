package edu.geekhub.lecture.mocking.example3.stubbing;

import edu.geekhub.lecture.mocking.Address;
import edu.geekhub.lecture.mocking.BannedUsersClient;
import edu.geekhub.lecture.mocking.User;
import edu.geekhub.lecture.mocking.util.LectureUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArgumentMatchersExampleTest {

    private static final User EXAMPLE_USER = new User(
        LectureUtil.randomNumber(),
        LectureUtil.randomAlphabeticString(),
        LectureUtil.randomAlphabeticString(),
        LocalDate.now()
    );

    @Mock
    private BannedUsersClient bannedUsersClient;

    static void print(boolean result) {
        System.out.println(result);
    }

    @Test
    void defaultBehaviour() {
        print(bannedUsersClient.isBanned("bruce", new Address()));
    }

    @Test
    void basicStubbing() {
        when(bannedUsersClient.isBanned("bruce", new Address()))
            .thenReturn(true);

        print(bannedUsersClient.isBanned("bruce", new Address()));
        print(bannedUsersClient.isBanned("bruce", null));
        print(bannedUsersClient.isBanned("clark", new Address()));
    }

    @Test
    void basicStubbingWithArgumentMatchers() {
        when(bannedUsersClient.isBanned(eq("bruce"), any(Address.class)))
            .thenReturn(true);

        when(bannedUsersClient.isBanned(anyString(), isNull()))
            .thenReturn(true);

        when(bannedUsersClient.isBanned(argThat(s -> s.length() <= 3), isNull()))
            .thenReturn(false);

        print(bannedUsersClient.isBanned("bruce", new Address()));
        print(bannedUsersClient.isBanned("shdshfhsdlf", null));
        print(bannedUsersClient.isBanned("foo", null));
    }

    @Test
    void basicStubbingUsageThrows() {
        when(bannedUsersClient.isBanned(eq("bruce"), any()))
            .thenThrow(new RuntimeException("Remote system is down!"));

        print(bannedUsersClient.isBanned("clark", null));

        assertThrows(
            RuntimeException.class,
            () -> print(bannedUsersClient.isBanned("bruce", new Address()))
        );
    }

    @Test
    void basicStubbingUsageCallRealMethod() {
        when(bannedUsersClient.isBanned(eq("bruce"), any(Address.class)))
            .thenCallRealMethod();

        print(bannedUsersClient.isBanned("bruce", new Address()));
    }
}
