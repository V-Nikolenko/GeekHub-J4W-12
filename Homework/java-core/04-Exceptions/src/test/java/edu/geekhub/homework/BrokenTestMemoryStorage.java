package edu.geekhub.homework;

import edu.geekhub.exceptions.ConnectionInterruptedException;
import edu.geekhub.models.User;
import edu.geekhub.storage.Repository;

public class BrokenTestMemoryStorage implements Repository {
    @Override
    public void tryToAdd(User user) throws ConnectionInterruptedException {
        throw new ConnectionInterruptedException("Test Exception");
    }

    @Override
    public User[] tryToGetAll() throws ConnectionInterruptedException {
        throw new ConnectionInterruptedException("Test Exception");
    }
}
