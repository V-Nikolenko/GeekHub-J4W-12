package edu.geekhub.homework;

import edu.geekhub.storage.Repository;
import edu.geekhub.storage.MemoryStorage;

// Don't move this class
public class UserService {

    private final Repository repository;

    public UserService() {
        this.repository = new MemoryStorage();
    }

    public UserService(Repository repository) {
        this.repository = repository;
    }

    //ToDo Write homework-related code here
}
