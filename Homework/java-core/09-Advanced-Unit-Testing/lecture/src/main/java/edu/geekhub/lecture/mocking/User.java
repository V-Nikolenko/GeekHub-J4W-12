package edu.geekhub.lecture.mocking;

import java.time.LocalDate;

public record User(
    Integer id,
    String username,
    String email,
    LocalDate createdAt
) {

    /**
     * Part of Empty Object pattern
     */
    private static final User EMPTY_USER = new User(
        null,
        null,
        null,
        null
    );

    public User withId(Integer userId) {
        return new User(
            userId,
            this.username,
            this.email,
            this.createdAt
        );
    }

    public static User createNewUser(String username, LocalDate createdAt) {
        return new User(
            null,
            username,
            null,
            createdAt
        );
    }

    public static User createNewUser(String username, LocalDate createdAt, String email) {
        return new User(
            null,
            username,
            email,
            createdAt
        );
    }

    /**
     * Part of Empty Object pattern
     */
    public static User createEmpty() {
        return EMPTY_USER;
    }
}
