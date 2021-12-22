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
            boolean quit = true;
            String cell = null;
            while (quit) {
                quit = game.Next_Shoot();
                cell = game.ask_cell();
                if (cell != null)
                    client.CreateRequest(args[1], cell);
            }
            System.out.println("Quited");
        } else {
            System.out.println("No client");
        }
    }
}
