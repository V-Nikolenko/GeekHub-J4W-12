package edu.geekhub.storage;

import edu.geekhub.exceptions.ConnectionInterruptedException;
import edu.geekhub.models.User;

public interface Repository {

    void tryToAdd(User user) throws ConnectionInterruptedException;

    User[] tryToGetAll() throws ConnectionInterruptedException;
}
