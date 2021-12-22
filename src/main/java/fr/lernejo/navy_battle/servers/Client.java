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

    public void CreateStartRequest(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/start"))
            .setHeader("accept", "application/json")
            .setHeader( "Content-Type", "application/json" )
            .POST( HttpRequest.BodyPublishers.ofString( "{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"I will win\"}" ) )
            .build();

        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
