package edu.geekhub.storage;

import edu.geekhub.exceptions.ConstraintException;
import edu.geekhub.models.User;

import java.util.Objects;

// Don't change this class
public final class ConstraintValidator {

    void validate(User user) {
        if (Objects.isNull(user.getEmail())) {
            throw new ConstraintException("User email cannot be null");
        }

        if (Objects.isNull(user.getUserName())) {
            throw new ConstraintException("Username cannot be null");
        }

        if (Objects.isNull(user.getAge())) {
            throw new ConstraintException("User age cannot be null");
        }
    }
}