package fr.lernejo.navy_battle.servers.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.lernejo.navy_battle.game.Game;

import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class GameStartHandler implements HttpHandler {
    private final Game game;
    private final HttpClient client;
    private final int port;

    public GameStartHandler(Game game, int port) {
        this.game = game;
        this.client = HttpClient.newHttpClient();
        this.port = port;
    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String response;
        if (requestMethod.equals("POST")){
            System.out.println("request start received on port " + this.port);
            response = "{\"id\":\"1\", \"url\":\"http://localhost:" + this.port+  "\", \"message\":\"No, I will win\"}";
            exchange.sendResponseHeaders(202, response.length());
            this.game.seturl(mon_json(new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8)).get("url").toString());
        }else{
            response = "Bad Request";
            exchange.sendResponseHeaders(400, response.length());
        }
        try ( OutputStream os = exchange.getResponseBody() ) { os.write( response.getBytes() ); }
        try {
            System.out.println("try shoot after start");
            this.game.Next_Shoot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public JSONObject mon_json(InputStreamReader stream) throws IOException {
        int b;
        BufferedReader br = new BufferedReader(stream);
        StringBuilder buf = new StringBuilder();
        while ((b = br.read()) != -1)
            buf.append((char) b);
        String requestBody = buf.toString();
        br.close();
        stream.close();
        System.out.println(requestBody);
        return new JSONObject(requestBody);
    }
}
