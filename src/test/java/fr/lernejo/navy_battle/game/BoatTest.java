package fr.lernejo.navy_battle.game;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BoatTest {
    Boat boat = new Boat(3,3,3,4);
    @Test
    void getposx1_of_3_should_produce_3() {
        int result = boat.getPosx1();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(3);
    }
    @Test
    void getposy1_of_3_should_produce_3() {
        int result = boat.getPosx1();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(3);
    }
    @Test
    void getposx2_of_3_should_produce_3() {
        int result = boat.getPosx1();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(3);
    }
    @Test
    void getposy2_of_3_should_produce_3() {
        int result = boat.getPosx1();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(3);
    }
    @Test
    void getsize_should_produce_2() {
        int result = boat.getSize();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(2);
    }
    @Test
    void getcase_should_produce_3334() {
        int[][] result = boat.getcases();
        Assertions.assertThat(result).as("x1 of boat")
            .isEqualTo(new int[][] {{3,3}, {3,4}});
    }
}
