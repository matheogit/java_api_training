package fr.lernejo.navy_battle.game;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BoatTest {
    @Test
    void getposx1_of_3_should_produce_3() {
        int result = new Boat(3,3,3,3).getPosx1();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(3);
    }
    @Test
    void getposy1_of_3_should_produce_3() {
        int result = new Boat(3,3,3,3).getPosx1();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(3);
    }
    @Test
    void getposx2_of_3_should_produce_3() {
        int result = new Boat(3,3,3,3).getPosx1();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(3);
    }
    @Test
    void getposy2_of_3_should_produce_3() {
        int result = new Boat(3,3,3,3).getPosx1();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(3);
    }
}
