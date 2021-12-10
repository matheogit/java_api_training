package fr.lernejo.navy_battle.servers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    private final int port;
    private final HttpClient client;

    public Client(int port) {
        this.port = port;
        this.client = HttpClient.newHttpClient();
    }

    public void CreateRequest(String url) {
        HttpRequest requestPost = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}"))
            .build();
        this.client.sendAsync(requestPost, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::headers)
            .thenAccept(System.out::println)
            .join();
    }
}
