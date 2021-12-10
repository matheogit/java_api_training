package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.servers.Client;
import fr.lernejo.navy_battle.servers.Server;

public class Launcher {
    public static void main(String[] args){
        if(args.length >= 1) {
            try {
                Server server = new Server(Integer.parseInt(args[0]));
                server.StartServer();
            } catch(NumberFormatException e) {
                System.out.println("wrong parameters");
                return;
            }
        }
        if(args.length >= 2) {
            try {
                Client client = new Client(Integer.parseInt(args[0]));
                client.CreateRequest(args[1]);
            } catch(NumberFormatException e) {
                System.out.println("wrong parameters");
            }
        }
    }
}
