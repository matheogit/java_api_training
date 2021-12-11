package fr.lernejo.navy_battle.game;

import java.util.ArrayList;

public class Player {
    private final String[][] sea = new String[10][10];
    private final ArrayList<Boat> boats;

    public Player(ArrayList<Boat> boats) {
        this.boats = boats;
    }

    public void Init_Sea() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                this.sea[i][j] = "-";
            }
        }
        for (Boat boat: this.boats) {
            this.Set_Boat(boat.getPosx1(), boat.getPosy1(), boat.getPosx2(), boat.getPosy2());
        }
    }

    public void Set_Boat(int x1, int y1, int x2, int y2) {
        if(x1 == x2) {
            if(y1 < y2) {
                for(int i = y1; i < y2; i++) {
                    this.sea[i][x1] = "o";
                }
            } else {
                for(int i = y2; i < y1; i++) {
                    this.sea[i][x1] = "o";
                }
            }
        } else {
            if(x1 < x2) {
                for(int i = x1; i < x2; i++) {
                    this.sea[y1][i] = "o";
                }
            } else {
                for(int i = x2; i < x1; i++) {
                    this.sea[y1][i] = "o";
                }
            }
        }
    }

    public void setSea(int i, int j) {
        this.sea[i][j] = "x";
    }

    public String getSea(int i, int j) {
        return this.sea[i][j];
    }

    public boolean shipLeft() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(this.sea[i][j] == "o")
                    return true;
            }
        }
        System.out.println("Game end");
        return false;
    }

    public void Print_Sea() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(this.sea[i][j]);
            }
            System.out.println();
        }
    }
}
