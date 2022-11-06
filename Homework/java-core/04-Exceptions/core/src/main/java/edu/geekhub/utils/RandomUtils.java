package edu.geekhub.utils;

import java.security.SecureRandom;

public class RandomUtils {

    private static SecureRandom random = new SecureRandom();

    public static String getRandomString(int size) {
        final char from = 'A';
        final char to = 'z';

        if (size <= 0) {
            return "";
        }

        return random.ints(from, to)
               .limit(size)
               .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
               .toString();
    }

    public static String getRandomElement(String[] array) {
        int elementIndex = random.nextInt(array.length - 1);
        return array[elementIndex];
    }
}
