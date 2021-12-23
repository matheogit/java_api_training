package fr.lernejo.navy_battle.servers.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.lernejo.navy_battle.game.Game;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GameFireHandler implements HttpHandler {
    private final Game game;
    private final int port;
    public GameFireHandler(Game game, int port) {
        this.game = game;
        this.port = port;
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
        try {
            this.createResponse(exchange, consequence, shipLeft);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createResponse(HttpExchange exchange, String consequence, boolean shipLeft) throws IOException, InterruptedException {
        String response;
        if(consequence != null) {
            response = "{\"consequence\":\"" + consequence + "\",\"shipLeft\":\"" + shipLeft + "\"}";
            exchange.getResponseHeaders().set( "Content-Type", "application/json" );
            exchange.sendResponseHeaders(202, response.length());
        } else {
            response = "Bad Request";
            exchange.getResponseHeaders().set( "Content-Type", "application/json" );
            exchange.sendResponseHeaders(400, response.length());
        }
        try ( OutputStream os = exchange.getResponseBody() ) { os.write( response.getBytes() ); }
        try {System.out.println("shoot received on port " + this.port);
            if (!shipLeft){ System.out.println("game end"); System.exit(1);}
            else this.game.Next_Shoot();} catch (InterruptedException e) {e.printStackTrace();}
    }
}
