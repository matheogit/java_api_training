package fr.lernejo.navy_battle.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Player[] player = new Player[2];
    int turn = 1;
    boolean end = true;
    Scanner scanner = new Scanner(System.in);

    public Game() {

    }

    public void Init() {

        for(int i = 0; i < 2; i++) {
            ArrayList<Boat> boats = new ArrayList<>();
            for(int j = 0; j < 1; j++) {
                System.out.print("x1: ");
                int x1 = this.scanner.nextInt();
                System.out.print("y1: ");
                int y1 = this.scanner.nextInt();
                System.out.print("x2: ");
                int x2 = this.scanner.nextInt();
                System.out.print("y2: ");
                int y2 = this.scanner.nextInt();
                boats.add(new Boat(x1, y1, x2, y2));
            }
            this.player[i]  = new Player(boats);
            this.player[i].Init_Sea();
        }
    }

    public String getConsequence(String cell) {
        int[] coordinate = getCoordinatefromcell(cell);
        String test = cell_test(this.player[(this.turn + 1) % 2].getSea(coordinate[0], coordinate[1]));
        if(test.equals("")) {
            System.out.println("erreur consequence");
            return null;
        } else {
            this.player[(this.turn + 1) % 2].setSea(coordinate[0], coordinate[1]);
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
        if (this.end)
            this.end = this.player[(this.turn + 1) % 2].shipLeft();
        return this.player[(this.turn + 1) % 2].shipLeft();
    }

    public boolean Next_Shoot() {
        turn = (turn + 1) % 2;
        this.Print_Game();
        int player = turn + 1;
        System.out.println("Player " + player + " to play");
        return this.end;
    }

    public String ask_cell() {
        System.out.print("Cell: ");
        String cell = this.scanner.next();
        return cell;
    }

    public void Print_Game() {
        System.out.println("Player 1");
        System.out.print(" \t");
        for(char i = 'A'; i < 'K'; i++) {
            System.out.print(i);
        }
        System.out.println();
        this.player[0].Print_Sea();
        System.out.println("///////////////////////");
        System.out.print(" \t");
        for(char i = 'A'; i < 'K'; i++) {
            System.out.print(i);
        }
        System.out.println();
        this.player[1].Print_Sea();
        System.out.println("Player 2");
    }
}
