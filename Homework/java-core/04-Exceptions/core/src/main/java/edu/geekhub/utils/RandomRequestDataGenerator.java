package edu.geekhub.utils;

import edu.geekhub.models.request.Request;

public class RandomRequestDataGenerator implements RequestDataGenerator {

    @Override
    public Request generate() {
        return new Request();
    }
}
