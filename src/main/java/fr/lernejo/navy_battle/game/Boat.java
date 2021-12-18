package fr.lernejo.navy_battle.game;

public class Boat {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Boat(int x1, int y1, int x2, int y2) {
        if(x1 == x2) {
            if(y1 < y2) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            } else {
                this.x1 = x2;
                this.y1 = y2;
                this.x2 = x1;
                this.y2 = y1;
            }
        } else {
            if(x1 < x2) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            } else {
                this.x1 = x2;
                this.y1 = y2;
                this.x2 = x1;
                this.y2 = y1;
            }
        }
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

    public int getSize() {
        if(x1 == x2) {
            if(y1 < y2) {
                return y2 - y1 + 1;
            } else {
                return y1 - y2 + 1;
            }
        } else {
            if(x1 < x2) {
                return x2 - x1 + 1;
            } else {
                return x1 - x2 + 1;
            }
        }
    }

    public int[][] getcases() {
        int[][] cases = new int[this.getSize()][2];
        if(this.x1 == this.x2) {
            for(int i = this.y1; i <= this.y2; i++) {
                cases[i-this.y1][0] = this.x1;
                cases[i-this.y1][1] = i;
            }
        } else {
            for(int i = this.x1; i <= this.x2; i++) {
                cases[i-this.x1][0] = i;
                cases[i-this.x1][1] = this.y1;
            }
        }
        return cases;
    }
}
