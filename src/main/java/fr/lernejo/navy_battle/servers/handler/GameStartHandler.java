package fr.lernejo.navy_battle.servers.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.lernejo.navy_battle.game.Game;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GameStartHandler implements HttpHandler {
    private final Game game;
    private final HttpClient client;
    public GameStartHandler(Game game) {
        this.game = game;
        this.client = HttpClient.newHttpClient();
    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String response;
        OutputStream os;
        if (requestMethod.equals("POST")){
            response = "{\"id\":\"1\", \"url\":\"http://localhost:" + exchange.getHttpContext().getServer().getAddress().getPort() +  "\", \"message\":\"No, I will win\"}";
            exchange.sendResponseHeaders(202, response.length());
        }else{
            response = "Bad Request";
            exchange.sendResponseHeaders(400, response.length());
        }
        os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        try {
            this.fire(exchange);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    public void fire(HttpExchange exchange) throws IOException, InterruptedException {
        String cell = "A1";
        String url = "http://localhost:" + exchange.getHttpContext().getServer().getAddress().getPort();
        this.CreateFireRequest(url, cell);
    }

    public void CreateFireRequest(String url, String cell) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(url + "/api/game/fire?cell=" + cell))
            .header("accept", "application/json")
            .build();

        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
