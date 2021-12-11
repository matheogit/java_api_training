package fr.lernejo.navy_battle.game;

public class Boat {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Boat(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getPosx1() {
        return this.x1;
    }

    public int getPosy1() {
        return this.y1;
    }

    public int getPosx2() {
        return this.x2;
    }

    public int getPosy2() {
        return this.y2;
    }
}
