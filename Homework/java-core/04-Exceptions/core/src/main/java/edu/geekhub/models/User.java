package edu.geekhub.models;

import java.time.ZonedDateTime;
import java.util.UUID;

public class User {

    private final UUID id; // no duplicates in db
    private final String email; // not null, unique, not empty, no spaces, no special symbols, email
    private final String userName; // not null, unique, not empty, no spaces, no special symbols
    private final String fullName; //Kunchenko-Harchenko Valentina, Misha Miron
    private final Integer age; // more than 18, not null
    private final String phoneNumber; // Nullable //Empty String
    private final String notes; // Nullable, empty
    private final String avatar; // not null, not empty, is url
    private final Long amountOfFollowers; // Is zero or bigger number, non null

    public User(UUID id,
                String email,
                String userName,
                String fullName,
                Integer age,
                String phoneNumber,
                String notes,
                String avatar,
                Long amountOfFollowers) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.avatar = avatar;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public String getAvatar() {
        return avatar;
    }

    public Long getAmountOfFollowers() {
        return amountOfFollowers;
    }
}