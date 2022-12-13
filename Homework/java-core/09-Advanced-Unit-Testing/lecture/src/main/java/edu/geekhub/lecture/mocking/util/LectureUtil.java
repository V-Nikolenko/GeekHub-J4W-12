package edu.geekhub.lecture.mocking.util;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LectureUtil {

    private static final Random RANDOM = new Random();

    private LectureUtil() {
    }

    public static void sleepSeconds(int secondsToSleep) {
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int randomNumber() {
        return RANDOM.nextInt(0, Integer.MAX_VALUE);
    }

    public static String randomAlphabeticString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        return RANDOM.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
