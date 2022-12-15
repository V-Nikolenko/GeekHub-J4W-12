package edu.geekhub.lecture.mocking;

import java.time.LocalDate;

public class UserRegistrationService {

    private final UserRepository userRepository;
    private final BannedUsersClient bannedUsersClient;

    public UserRegistrationService(
        UserRepository userRepository,
        BannedUsersClient bannedUsersClient
    ) {
        this.userRepository = userRepository;
        this.bannedUsersClient = bannedUsersClient;
    }

    public User registerUser(String username, ContactInformation contactInformation) {
        if (bannedUsersClient.isBanned(username, contactInformation.address())) {
            throw new IllegalArgumentException("This user is banned from our system");
        }

        var existingUser = userRepository.findByUsername(username);

        if (existingUser != null) {
            return existingUser;
        }

        var userEmail = prepareUserEmail(username, contactInformation);
        var user = User.createNewUser(username, LocalDate.now(), userEmail);

        return userRepository.save(user);
    }

    private static String prepareUserEmail(String username, ContactInformation contactInformation) {
        String userEmail;
        if (contactInformation.email() == null) {
            userEmail = username + "@gmail.com";
        } else {
            userEmail = contactInformation.email();
        }

        return userEmail;
    }

    public void forgotUser(User user) {
        userRepository.delete(user);
    }
}
