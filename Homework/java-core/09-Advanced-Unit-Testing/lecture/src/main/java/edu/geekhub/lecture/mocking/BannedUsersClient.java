package edu.geekhub.lecture.mocking;

import static edu.geekhub.lecture.mocking.util.LectureUtil.sleepSeconds;

public class BannedUsersClient {

    public boolean isBanned(String username, Address address) {
        System.out.println("Checking if " + username + " at given address is banned in a remote system");

        sleepSeconds(7);

        return false;
    }

}
