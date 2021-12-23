package fr.lernejo.navy_battle.game;

import fr.lernejo.navy_battle.servers.Client;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private final Player[] player = new Player[2];
    private final int[] turn = new int[1];
    private final boolean[] end = new boolean[1];
    private final String[] url = new String [2];
    private final ArrayList<String> shootlist = new ArrayList();
    private final String[] boatlist = {"PORTEAVION", "CROISEUR", "CONTRETORPILLEURS", "CONTRETORPILLEURS", "TORPILLEUR"};
    public Game() {
        this.player[0] = new Player();
        this.player[1] = new Player();
    }

    public void Init() {
        for(int i = 0; i < 2; i++)
            this.player[i].Add_Boat(new Boat(0, 2, 1, 2));
    }

    public String getConsequence(String cell) {
        int[] coordinate = getCoordinatefromcell(cell);
        String test = cell_test(this.player[(this.turn[0] + 1) % 2].getCase(coordinate[0], coordinate[1]));
        if(test.equals("")) {
            System.out.println("erreur consequence");
            return null;
        } else {
            this.player[(this.turn[0] + 1) % 2].setShoot(coordinate[0], coordinate[1]);
            test = this.player[(this.turn[0] + 1) % 2].getsunk(test);
            return test;
        }
    }

    public String cell_test(String case_test) {
        switch (case_test) {
            case "x" -> {
                return "";
            }
            case "o" -> {
                return "hit";
            }
            case "-" -> {
                return "miss";
            }
            default -> {
                System.out.println("Error sea");
                return "";
            }
        }
    }

    public int[] getCoordinatefromcell(String cell) {
        int[] coordinate = new int[2];
        coordinate[0] = Integer.parseInt(cell.substring(1)) - 1;
        char letter = cell.charAt(0);
        coordinate[1] = letter - 'A';
        return coordinate;
    }

    public boolean getshipLeft() {
        if (this.end[0])
            this.end[0] = this.player[(this.turn[0] + 1) % 2].shipLeft();
        return this.player[(this.turn[0] + 1) % 2].shipLeft();
    }

    public void seturl(String url) {
        this.url[0] = url;
    }

    public boolean Next_Shoot() throws IOException, InterruptedException {
        this.turn[0] = (this.turn[0] + 1) % 2;
        String cell = "";
        do{
            System.out.print("search");
            cell = Character.toString( (char)((int)(Math.random() * 10) + (int)'A') ) + (int)(Math.random() * (10 - 1) + 1);
        } while(this.shootlist.contains(cell));
        this.shootlist.add(cell);
        System.out.println("shoot to url " + this.url[0] + " on cell" + cell);
        new Client(1).CreateFireRequest(this.url[0], cell);
        return this.end[0];
    }
}
