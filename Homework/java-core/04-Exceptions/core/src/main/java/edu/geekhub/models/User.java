package edu.geekhub.models;

import java.util.UUID;

public class User {

    private final UUID id; // no duplicates in db
    private final String email; // not null, unique, not empty, no spaces, no special symbols, email
    private final String userName; // not null, unique, not empty, no spaces, no special symbols
    private final String fullName; //Kunchenko-Harchenko Valentina, Misha Miron
    private final Integer age; // more than 18, not null
    private final String notes; // Nullable, empty
    private final Long amountOfFollowers; // Is zero or bigger number, non null

    private User(UUID id,
                String email,
                String userName,
                String fullName,
                Integer age,
                String notes,
                Long amountOfFollowers) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.age = age;
        this.notes = notes;
        this.amountOfFollowers = amountOfFollowers;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    public String getNotes() {
        return notes;
    }

    public Long getAmountOfFollowers() {
        return amountOfFollowers;
    }

    public static UserBuilder toBuilder() {
        return new UserBuilder();
    }

    public static final class UserBuilder {
        private UUID id; // no duplicates in db
        private String email; // not null, unique, not empty, no spaces, no special symbols, email
        private String userName; // not null, unique, not empty, no spaces, no special symbols
        private String fullName; //Kunchenko-Harchenko Valentina, Misha Miron
        private Integer age; // more than 18, not null
        private String notes; // Nullable, empty
        private Long amountOfFollowers; // Is zero or bigger number, non null

        private UserBuilder() {
        }

        public UserBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder withNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public UserBuilder withAmountOfFollowers(Long amountOfFollowers) {
            this.amountOfFollowers = amountOfFollowers;
            return this;
        }

        public User build() {
            return new User(id, email, userName, fullName, age, notes, amountOfFollowers);
        }
    }
}