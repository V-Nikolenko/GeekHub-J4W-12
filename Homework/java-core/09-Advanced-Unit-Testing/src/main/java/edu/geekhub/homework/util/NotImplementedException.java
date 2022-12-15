package edu.geekhub.homework.util;

public class NotImplementedException extends RuntimeException {

    private NotImplementedException(String message) {
        super(message);
    }

    public static void TODO() {
        TODO("");
    }

    public static void TODO(String message) {
        throw new NotImplementedException(message);
    }

    public static <T> T TODO_TYPE() {
        return TODO_TYPE("");
    }
    public static <T> T TODO_TYPE(String message) {
        throw new NotImplementedException(message);
    }
}
