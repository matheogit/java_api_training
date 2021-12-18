package fr.lernejo.navy_battle.servers.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.lernejo.navy_battle.game.Game;

import java.io.IOException;
import java.io.OutputStream;

public class GameFireHandler implements HttpHandler {
    private final Game game;
    public GameFireHandler(Game game) {
        this.game = game;
    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String consequence = null;
        if (exchange.getRequestMethod().equals("GET")) {
            String params = exchange.getRequestURI().getQuery();
            String cell = params.substring(5);
            consequence = this.game.getConsequence(cell);
        }
        boolean shipLeft = this.game.getshipLeft();
        this.createResponse(exchange, consequence, shipLeft);
    }

    public void createResponse(HttpExchange exchange, String consequence, boolean shipLeft) throws IOException {
        String response;
        OutputStream os;
        if(consequence != null) {
            response = "{\"consequence\":\"" + consequence + "\",\"shipLeft\":\"" + shipLeft + "\"}";
            exchange.sendResponseHeaders(202, response.length());
            os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
            if(!shipLeft)
                System.exit(1);
        } else {
            response = "Bad Request";
            exchange.sendResponseHeaders(400, response.length());
            os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
