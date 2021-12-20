package fr.lernejo.navy_battle.game;

import java.util.Scanner;

public class Game {
    private final Player[] player = new Player[2];
    private int turn = 1;
    private boolean end = true;
    private final Scanner scanner = new Scanner(System.in);
    private final String[] boatlist = {"PORTEAVION", "CROISEUR", "CONTRETORPILLEURS", "CONTRETORPILLEURS", "TORPILLEUR"};
    public Game() {
        this.player[0] = new Player();
        this.player[1] = new Player();
    }

    public void Init() {
        for(int i = 0; i < 2; i++) {
            for (String type: boatlist) {
                System.out.println("Player " + (i + 1));
                this.player[i].Print_Sea();
                boolean exit = false;
                while (!exit) {
                    int[] pos1, pos2;
                    int size = BoatType.valueOf(type).getsize();
                    System.out.print("Boat of size "+ size + " start from ");
                    String cell1 = this.ask_cell();
                    System.out.print("To ");
                    String cell2 = this.ask_cell();
                    pos1 = getCoordinatefromcell(cell1);
                    pos2 = getCoordinatefromcell(cell2);
                    if(new Boat(pos1[0], pos1[1], pos2[0], pos2[1]).getSize() == size) {
                        exit = this.player[i].Add_Boat(new Boat(pos1[0], pos1[1], pos2[0], pos2[1]));
                    }
                    else {
                        System.out.println("Size problem");
                    }
                }
            }
        }
    }

    public String getConsequence(String cell) {
        int[] coordinate = getCoordinatefromcell(cell);
        String test = cell_test(this.player[(this.turn + 1) % 2].getCase(coordinate[0], coordinate[1]));
        if(test.equals("")) {
            System.out.println("erreur consequence");
            return null;
        } else {
            this.player[(this.turn + 1) % 2].setShoot(coordinate[0], coordinate[1]);
            test = this.player[(this.turn + 1) % 2].getsunk(test);
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
        boolean exit = true;
        String cell = "";
        while(exit) {
            System.out.print("cell: ");
            cell = scanner.nextLine();
            if(cell.matches("^[A-J]+([1-9]|10)$")) {
                exit = false;
            }
            else
                System.out.println("Wrong cell example: C4");
        }
        return cell;
    }

    public void Print_Game() {
        System.out.println("Player 1");
        this.player[0].Print_Sea();
        System.out.println("///////////////////////");
        this.player[1].Print_Sea();
        System.out.println("Player 2");
    }
}
