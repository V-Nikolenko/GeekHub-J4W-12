package edu.geekhub.storage;

import edu.geekhub.exceptions.ConnectionInterruptedException;
import edu.geekhub.models.User;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

// Don't change this class
public final class MemoryStorage implements Repository {

    private final SecureRandom arbitrator = new SecureRandom();
    private final ConstraintValidator validator = new ConstraintValidator();

    private final List<User> users = new ArrayList<>();

    public void tryToAdd(User user) throws ConnectionInterruptedException {
        boolean yourDestiny = arbitrator.nextBoolean();

        if (!yourDestiny) {
            throw new ConnectionInterruptedException("Connection was closed due to unexpected error");
        }

        validator.validate(user);

        users.add(user);
    }

    public User[] tryToGetAll() throws ConnectionInterruptedException {
        boolean yourDestiny = arbitrator.nextBoolean();

        if (!yourDestiny) {
            throw new ConnectionInterruptedException("Connection was closed due to unexpected error");
        }

        return users.toArray(User[]::new);
    }
}