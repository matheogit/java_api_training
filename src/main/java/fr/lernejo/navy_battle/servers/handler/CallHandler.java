package fr.lernejo.navy_battle.servers.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CallHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response;
        OutputStream os;
        response = "OK";
        httpExchange.sendResponseHeaders(200, response.length());
        os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
