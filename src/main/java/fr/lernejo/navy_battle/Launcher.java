package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.game.Game;
import fr.lernejo.navy_battle.servers.Client;
import fr.lernejo.navy_battle.servers.Server;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        //game.Init();
        if(args.length >= 1) {
            Server server = new Server(Integer.parseInt(args[0]), game);
            server.StartServer();
        }
        if(args.length >= 2) {
            Client client = new Client(Integer.parseInt(args[0]), game);
            client.CreateStartRequest(args[1]);
            client.CreateFireRequest("http://localhost:" + args[0], "A1");
            client.CreateFireRequest(args[1], "A1");
        }
    }
}
