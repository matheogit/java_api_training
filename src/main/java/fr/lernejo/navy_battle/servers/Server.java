package fr.lernejo.navy_battle.servers;

import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.game.Game;
import fr.lernejo.navy_battle.servers.handler.CallHandler;
import fr.lernejo.navy_battle.servers.handler.GameFireHandler;
import fr.lernejo.navy_battle.servers.handler.GameStartHandler;

import java.net.InetSocketAddress;

import java.util.concurrent.*;

public class Server {
    private final int port;
    private final Game game;

    public Server(int port, Game game) {
        this.port = port;
        this.game = game;
    }

    public void StartServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(this.port), 0);
            server.createContext("/ping", new CallHandler());
            server.createContext("/api/game/start", new GameStartHandler(this.game));
            server.createContext("/api/game/fire", new GameFireHandler(this.game));
            server.setExecutor(Executors.newFixedThreadPool(1));
            server.start();
        } catch (java.io.IOException e) {
            System.out.println("error starting server");
        }
    }
}
