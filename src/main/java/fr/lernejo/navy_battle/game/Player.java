package fr.lernejo.navy_battle.game;

import java.util.ArrayList;

public class Player {
    private final String[][] sea = new String[10][10];
    private final ArrayList<Boat> boats;

    public Player() {
        this.boats = new ArrayList<>();
        this.Init_Sea();
    }

    public void Init_Sea() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                this.sea[i][j] = "-";
            }
        }
    }

    public String[][] getSea(){
        return this.sea;
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public boolean Add_Boat(Boat boat) {
        this.boats.add(boat);
        return this.setBoats(boat);
    }

    private boolean setBoats(Boat boat) {
        if(boat.getPosx1() == boat.getPosx2()) {
            for(int i = boat.getPosy1(); i <= boat.getPosy2(); i++) {
                if(getCase(boat.getPosx1(), i).equals("o")) return false;
                else this.setBoat(boat.getPosx1(), i);
            }
        } else {
            for(int i = boat.getPosx1(); i <= boat.getPosx2(); i++) {
                if(getCase(i, boat.getPosy1()).equals("o")) return false;
                else this.setBoat(i, boat.getPosy1());
            }
        } return true;
    }

    public void setBoat(int i, int j) {
        this.sea[i][j] = "o";
    }

    public void setShoot(int i, int j) {
        this.sea[i][j] = "x";
    }

    public String getsunk(String test) {
        int[][] cases;
        boolean state;
        for (Boat boat: this.boats) {
            cases = boat.getcases();
            state = true;
            for (int[] aCase : cases) {
                if (this.getCase(aCase[0], aCase[1]).equals("o"))
                    state = false;
            }
            if(state) {
                this.boats.remove(boat);
                return "sunk";
            }
        }
        return test;
    }

    public String getCase(int i, int j) {
        return this.sea[i][j];
    }

    public boolean shipLeft() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(this.sea[i][j].equals("o"))
                    return true;
            }
        }
        System.out.println("Game end");
        return false;
    }
}
