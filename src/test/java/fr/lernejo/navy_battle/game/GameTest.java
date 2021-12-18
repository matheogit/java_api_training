package fr.lernejo.navy_battle.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void celltest_of_x_should_produce_nothing() {
        String result = new Game().cell_test("x");
        Assertions.assertThat(result).as("cell test of x")
            .isEqualTo("");
    }
    @Test
    void celltest_of_o_should_produce_nothing() {
        String result = new Game().cell_test("o");
        Assertions.assertThat(result).as("cell test of o")
            .isEqualTo("hit");
    }
    @Test
    void celltest_of_tiret_should_produce_nothing() {
        String result = new Game().cell_test("-");
        Assertions.assertThat(result).as("cell test of -")
            .isEqualTo("miss");
    }
    @Test
    void celltest_of_p_should_produce_nothing() {
        String result = new Game().cell_test("p");
        Assertions.assertThat(result).as("cell test of p")
            .isEqualTo("");
    }
    @Test
    void coofromcell_of_A3_should_produce_20() {
        int[] result = new Game().getCoordinatefromcell("A3");
        Assertions.assertThat(result).as("cell test of x")
            .isEqualTo(new int[] {2,0});
    }
}
