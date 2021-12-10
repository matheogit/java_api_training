package fr.lernejo.navy_battle.servers;

import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.servers.handler.CallHandler;
import fr.lernejo.navy_battle.servers.handler.GameStartHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void StartServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(this.port), 0);
            server.createContext("/ping", new CallHandler());
            server.createContext("/api/game/start", new GameStartHandler());
            server.setExecutor(new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>()));
            server.start();
        } catch (java.io.IOException e) {
            System.out.println("error starting server");
        }
    }
}
