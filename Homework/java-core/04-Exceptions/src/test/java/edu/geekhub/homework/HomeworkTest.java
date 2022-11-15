package edu.geekhub.homework;

import edu.geekhub.models.User;
import edu.geekhub.models.request.Request;
import edu.geekhub.models.request.Response;
import edu.geekhub.models.request.ResponseStatus;
import edu.geekhub.storage.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeworkTest {

    private TestMemoryStorage memoryStorage;
    private UserController controller;

    @BeforeEach
    public void setUp() {
        this.memoryStorage = new TestMemoryStorage();
        UserService testService = new UserService(memoryStorage);
        this.controller = new UserController(testService);
    }


    @Test
    @DisplayName("Should fail when we try to save user without ID")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithoutId() {
        User user = createValidUser()
                .asBuilder()
                .withId(null)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user with ID that already exists in memory storage")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithIdThatAlreadyExists() {
        User user = createValidUser();
        memoryStorage.tryToAdd(user);
        User newUser = user.asBuilder()
                .withUserName("unique_username")
                .withEmail("unique_email@stub.com")
                .build();
        Request request = new Request(newUser);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(1, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user without Email")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithoutEmail() {
        User user = createValidUser()
                .asBuilder()
                .withEmail(null)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    private static Stream<Arguments> provideInvalidEmailData() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("  "),
                Arguments.of("not blank"),
                Arguments.of("invalid email@stub.com"),
                Arguments.of("invalid.emailstub.com"),
                Arguments.of("invalid.email@test,stub"),
                Arguments.of("invalid.email@\"test.stub\""),
                Arguments.of("invalid.email@test .stub"),
                Arguments.of("invalid.email@tes`t.stub"),
                Arguments.of("invalid.email@test$bar"),
                Arguments.of("invalid.email@ foo.bar"),
                Arguments.of("invalid.email@ foo bar "),
                Arguments.of("invalid.email@'foo.bar'"),
                Arguments.of("invalid.email@@@foo.bar"),
                Arguments.of("invalid/email@foo.bar"),
                Arguments.of("[invalid.email@foo.bar]")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidEmailData")
    @DisplayName("Should fail when we try to save user with invalid Email")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithInvalidEmail(String email) {
        User user = createValidUser()
                .asBuilder()
                .withEmail(email)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user with Email that already exists in memory storage")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithEmailThatAlreadyExists() {
        User user = createValidUser();
        memoryStorage.tryToAdd(user);
        User newUser = createValidUser().asBuilder()
                .withUserName("unique_username")
                .build();
        Request request = new Request(newUser);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(1, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user without UserName")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithoutUserName() {
        User user = createValidUser()
                .asBuilder()
                .withUserName(null)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    private static Stream<Arguments> provideInvalidUserNameData() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("  "),
                Arguments.of("invalid username"),
                Arguments.of("invalid email@stub.com"),
                Arguments.of("invalid.emailstub.com"),
                Arguments.of("invalid.email@test,stub"),
                Arguments.of("\"invalid.username\""),
                Arguments.of("'invalid.username'"),
                Arguments.of("invalid.USERNAME"),
                Arguments.of("invalid`username"),
                Arguments.of("invalid$username"),
                Arguments.of("[invalid.username]"),
                Arguments.of("(invalid.username)")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidUserNameData")
    @DisplayName("Should fail when we try to save user with invalid UserName")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithInvalidUserName(String userName) {
        User user = createValidUser()
                .asBuilder()
                .withUserName(userName)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user with UserName that already exists in memory storage")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithUserNameThatAlreadyExists() {
        User user = createValidUser();
        memoryStorage.tryToAdd(user);
        User newUser = createValidUser()
                .asBuilder()
                .withEmail("unique_email@stub.com")
                .build();
        Request request = new Request(newUser);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(1, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user without full name")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithoutFullName() {
        User user = createValidUser()
                .asBuilder()
                .withFullName(null)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    private static Stream<Arguments> provideInvalidFullNameData() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("  "),
                Arguments.of("invalid fullname"),
                Arguments.of("Invalid FullName"),
                Arguments.of("\"Invalid Fullname\""),
                Arguments.of("'Invalid Fullname'"),
                Arguments.of("'Inval1d Fu11nam3'"),
                Arguments.of("Invalid.FULLNAME"),
                Arguments.of("Invalid`Fullname"),
                Arguments.of("Invalid$Fullname"),
                Arguments.of("[Invalid Fullname]"),
                Arguments.of("(Invalid Fullname)")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidFullNameData")
    @DisplayName("Should fail when we try to save user with invalid FullName")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithInvalidFullName(String fullName) {
        User user = createValidUser()
                .asBuilder()
                .withFullName(fullName)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user without age")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithoutAge() {
        User user = createValidUser()
                .asBuilder()
                .withAge(null)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user with age less than eighteen")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithAgeLessThenEighteen() {
        User user = createValidUser()
                .asBuilder()
                .withAge(17)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user with age less than zero")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithAgeLessThenZero() {
        User user = createValidUser()
                .asBuilder()
                .withAge(-1)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user with age bigger than one hundred")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithAgeBiggerThenOneHundred() {
        User user = createValidUser()
                .asBuilder()
                .withAge(101)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should success when we try to save user without notes")
    void process_shouldReturnSuccessStatus_whenWeTryingToSaveUserWithoutNotes() {
        User user = createValidUser()
                .asBuilder()
                .withNotes(null)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should success when we try to save user with empty notes")
    void process_shouldReturnSuccessStatus_whenWeTryingToSaveUserWithEmptyNotes() {
        User user = createValidUser()
                .asBuilder()
                .withNotes(" ")
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }

    @Test
    @DisplayName("Should fail when we try to save user with notes bigger than 255 chars")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithNotesBiggerThat255Chars() {
        User user = createValidUser()
                .asBuilder()
                .withNotes("TestNotes".repeat(20))
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }

    @Test
    @DisplayName("Should success when we try to save user without amount of followers")
    void process_shouldReturnSuccessStatus_whenWeTryingToSaveUserWithoutAmountOfFollowers() {
        User user = createValidUser()
                .asBuilder()
                .withAmountOfFollowers(null)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when we try to save user with amount of followers less than zero")
    void process_shouldReturnFailedStatus_whenWeTryingToSaveUserWithAmountOfFollowersLessThenZero() {
        User user = createValidUser()
                .asBuilder()
                .withAmountOfFollowers(-1L)
                .build();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should success when we try to save user with valid data")
    void process_shouldReturnSuccessStatus_whenWeTryingToSaveUserWithValidData() {
        User user = createValidUser();
        Request request = new Request(user);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.SUCCESS, response.getStatus());
        assertEquals(1, memoryStorage.tryToGetAll().length);
    }

    @Test
    @DisplayName("Should fail when memory repository throws exception")
    void process_shouldReturnFailedStatus_whenMemoryRepositoryThrowsException() {
        Repository testRepository = new BrokenTestMemoryStorage();
        UserService testUserService = new UserService(testRepository);
        UserController testController = new UserController(testUserService);
        User user = createValidUser();
        Request request = new Request(user);

        Response response = testController.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when request data is null")
    void process_shouldReturnFailedStatus_whenRequestDataIsNull() {
        Request request = new Request(null);

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }


    @Test
    @DisplayName("Should fail when request data is not user")
    void process_shouldReturnFailedStatus_whenRequestDataIsNotUser() {
        Request request = new Request("User?");

        Response response = controller.process(request);

        assertEquals(ResponseStatus.FAIL, response.getStatus());
        assertEquals(0, memoryStorage.tryToGetAll().length);
    }

    private User createValidUser() {
        return User.toBuilder()
                .withId(UUID.randomUUID())
                .withEmail("Valid.Email@stub.test")
                .withUserName("valid_username")
                .withFullName("Valid FullName")
                .withAge(22)
                .withNotes("Some notes about user")
                .withAmountOfFollowers(4L)
                .build();
    }
}
