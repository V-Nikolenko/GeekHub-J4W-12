package edu.geekhub.homework.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

/**
 * This class fetches data through internet connection from an a REST API endpoint. Please note that this class is
 * hard to cover by unit tests so its not required to write tests on this class,
 * but it should be used as dependency in other code
 * <br/>
 * <br/>
 * IMPORTANT: DO NOT CHANGE ANY LINE OF CODE IN THIS CLASS, OTHERWISE YOU WILL GET LOWER RATING OF HOMEWORK
 */
public final class LosesStatisticHttpClient {

    private static final String LOSES_STATISTIC_API_ENDPOINT =
        "https://639659c490ac47c68084529e.mockapi.io/loses-statistic";

    public String getAll() throws IOException, InterruptedException {
        var httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(LOSES_STATISTIC_API_ENDPOINT))
            .timeout(Duration.ofSeconds(1))
            .GET()
            .build();

        var httpResponse = HttpClient.newHttpClient()
            .send(httpRequest, BodyHandlers.ofString());

        return httpResponse.body();
    }

    public String getById(int id) throws IOException, InterruptedException {
        var httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(LOSES_STATISTIC_API_ENDPOINT + "/" + id))
            .timeout(Duration.ofSeconds(1))
            .GET()
            .build();

        var httpResponse = HttpClient.newHttpClient()
            .send(httpRequest, BodyHandlers.ofString());

        return httpResponse.body();
    }

    public void deleteAll() throws IOException, InterruptedException {
        var httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(LOSES_STATISTIC_API_ENDPOINT))
            .timeout(Duration.ofSeconds(1))
            .DELETE()
            .build();

        HttpClient.newHttpClient()
            .send(httpRequest, BodyHandlers.discarding());
    }

    public void deleteById(int id) throws IOException, InterruptedException {
        var httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(LOSES_STATISTIC_API_ENDPOINT + "/" + id))
            .timeout(Duration.ofSeconds(1))
            .DELETE()
            .build();

        HttpClient.newHttpClient()
            .send(httpRequest, BodyHandlers.ofString());
    }

    public void create(String losesStatisticJson) throws IOException, InterruptedException {
        var httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(LOSES_STATISTIC_API_ENDPOINT))
            .timeout(Duration.ofSeconds(1))
            .POST(BodyPublishers.ofString(losesStatisticJson))
            .build();

        HttpClient.newHttpClient()
            .send(httpRequest, BodyHandlers.ofString());
    }

}
