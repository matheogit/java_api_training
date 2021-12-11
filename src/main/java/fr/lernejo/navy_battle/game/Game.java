package fr.lernejo.navy_battle.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Player[] player = new Player[2];
    int turn = 0;

    public Game() {

    }

    public void Init() {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 2; i++) {
            ArrayList<Boat> boats = new ArrayList<Boat>();
            for(int j = 0; j < 5; j++) {
                System.out.print("x1: ");
                int x1 = scanner.nextInt();
                System.out.print("y1: ");
                int y1 = scanner.nextInt();
                System.out.print("x2: ");
                int x2 = scanner.nextInt();
                System.out.print("y2: ");
                int y2 = scanner.nextInt();
                boats.add(new Boat(x1, y1, x2, y2));
            }
            this.player[i]  = new Player(boats);
            this.player[i].Init_Sea();
        }
    }

    public String getConsequence(String cell, int player) {
        int[] coordinate = getCoordinatefromcell(cell);
        String test = test_case(this.player[player].getSea(coordinate[0], coordinate[1]));
        if(test.equals("")) {
            System.out.println("erreur consequence");
            return null;
        } else {
            this.player[player].setSea(coordinate[0], coordinate[1]);
            this.Next_Shoot();
            return test;
        }
    }

    public String test_case(String case_test) {
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
        System.out.println(coordinate);
        return coordinate;
    }
    public boolean getshipLeft() {
        return this.player[this.turn].shipLeft();
    }

    public int getTurn() {
        return this.turn;
    }

    public void Next_Shoot() {
        turn = (turn + 1) % 2;
        this.Print_Game();
    }

    public void Print_Game() {
        this.player[0].Print_Sea();
        System.out.println("///////////////////////");
        this.player[1].Print_Sea();
    }
}
