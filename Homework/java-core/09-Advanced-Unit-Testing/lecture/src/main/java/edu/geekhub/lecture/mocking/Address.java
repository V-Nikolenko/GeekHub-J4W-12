package edu.geekhub.lecture.mocking;

public record Address(
    String country,
    String city
) {
    public Address() {
        this(null, null);
    }
}
