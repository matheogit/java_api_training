package fr.lernejo.navy_battle.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatTypeTest {


    @Test
    void getsize() {
        int result = BoatType.CONTRETORPILLEURS.getsize();
        Assertions.assertThat(result).as("size of contretorpilleurs")
            .isEqualTo(3);
    }

    @Test
    void values() {
        BoatType[] result = BoatType.values();
        BoatType[] expected = {BoatType.PORTEAVION, BoatType.CROISEUR, BoatType.CONTRETORPILLEURS, BoatType.TORPILLEUR};
        Assertions.assertThat(result).as("values of boattype")
            .isEqualTo(expected);
    }

    @Test
    void valueOf_PORTAVION() {
        BoatType result = BoatType.valueOf("PORTEAVION");
        BoatType expected = BoatType.PORTEAVION;
        Assertions.assertThat(result).as("values of portavion")
            .isEqualTo(expected);
    }
}
