package edu.geekhub.homework.domain;

import edu.geekhub.homework.client.LosesStatisticHttpClient;

import static edu.geekhub.homework.util.NotImplementedException.TODO;
import static edu.geekhub.homework.util.NotImplementedException.TODO_TYPE;

/**
 * This class should contain data received through {@link LosesStatisticHttpClient}
 * via <a href="https://en.wikipedia.org/wiki/JSON">JSON</a> String
 */
public record LosesStatistic() {
    public LosesStatistic {
        TODO("Implement record that store data from JSON string");
    }

    public int id() {
        return TODO_TYPE();
    }
}
