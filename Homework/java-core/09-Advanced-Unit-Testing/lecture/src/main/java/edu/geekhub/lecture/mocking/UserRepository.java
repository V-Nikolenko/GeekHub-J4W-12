package edu.geekhub.lecture.mocking;

public interface UserRepository {
    User findByUsername(String username);

    User save(User user);

    void delete(User user);
}
