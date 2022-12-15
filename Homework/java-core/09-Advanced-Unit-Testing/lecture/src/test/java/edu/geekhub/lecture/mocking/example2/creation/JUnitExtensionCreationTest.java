package edu.geekhub.lecture.mocking.example2.creation;


import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.fail;

public class JUnitExtensionCreationTest {

    @BeforeEach
    void setUp() {
        fail("Implement creation of mocks by using JUnit 5 Extension");
//        new UserRegistrationService(userRepository, bannedUsersClient);
    }

}
