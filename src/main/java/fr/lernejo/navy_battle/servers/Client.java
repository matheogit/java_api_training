package fr.lernejo.navy_battle.servers;

import fr.lernejo.navy_battle.game.Game;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    private final int port;
    private final HttpClient client;
    private final Game game;

    public Client(int port, Game game) {
        this.port = port;
        this.client = HttpClient.newHttpClient();
        this.game = game;
    }

    public void CreateRequest(String url, String cell) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(url + "/api/game/fire?cell=" + cell))
            .header("accept", "application/json")
            .build();

        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
