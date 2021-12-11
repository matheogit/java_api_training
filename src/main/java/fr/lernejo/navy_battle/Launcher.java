package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.game.Game;
import fr.lernejo.navy_battle.servers.Client;
import fr.lernejo.navy_battle.servers.Server;

public class Launcher {
    public static void main(String[] args){
        Game game = new Game();
        game.Init();
        game.Next_Shoot();
        if(args.length >= 1) {
            Server server = new Server(Integer.parseInt(args[0]), game);
            server.StartServer();
        }
        if(args.length >= 2) {
            Client client = new Client(Integer.parseInt(args[0]), game);
            //client.CreateRequest(args[1]);
        }
    }
}
