package fr.lernejo.navy_battle.game;

public enum BoatType {
    PORTEAVION(5), CROISEUR(4), CONTRETORPILLEURS(3), TORPILLEUR(1);
    private final int size;

    BoatType(int size) {
        this.size = size;
    }

    public int getsize() {
        return this.size;
    }
}
