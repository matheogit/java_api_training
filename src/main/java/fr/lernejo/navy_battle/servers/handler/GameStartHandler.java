package fr.lernejo.navy_battle.servers.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class GameStartHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String response;
        OutputStream os;
        if (requestMethod.equals("POST")){
            response = "{\"id\":\"1\", \"url\":\"http://localhost:" + exchange.getHttpContext().getServer().getAddress().getPort() +  "\", \"message\":\"hello\"}";
            exchange.sendResponseHeaders(202, response.length());
        }else{
            response = "Bad Request";
            exchange.sendResponseHeaders(400, response.length());
        }
        os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
