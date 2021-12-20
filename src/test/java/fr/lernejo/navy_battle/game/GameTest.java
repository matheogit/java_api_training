package fr.lernejo.navy_battle.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class GameTest {
    Game game = new Game();
    @Test
    void celltest_of_x_should_produce_nothing() {
        String result = this.game.cell_test("x");
        Assertions.assertThat(result).as("cell test of x")
            .isEqualTo("");
    }
    @Test
    void celltest_of_o_should_produce_nothing() {
        String result = this.game.cell_test("o");
        Assertions.assertThat(result).as("cell test of o")
            .isEqualTo("hit");
    }
    @Test
    void celltest_of_tiret_should_produce_nothing() {
        String result = this.game.cell_test("-");
        Assertions.assertThat(result).as("cell test of -")
            .isEqualTo("miss");
    }
    @Test
    void celltest_of_p_should_produce_nothing() {
        String result = this.game.cell_test("p");
        Assertions.assertThat(result).as("cell test of p")
            .isEqualTo("");
    }
    @Test
    void coofromcell_of_A3_should_produce_20() {
        int[] result = this.game.getCoordinatefromcell("A3");
        Assertions.assertThat(result).as("cell test of x")
            .isEqualTo(new int[] {2,0});
    }

    @Test
    void getConsequence() {
        String result = this.game.getConsequence("A1");
        String expected = "miss";
        Assertions.assertThat(result).as("consequence of cell A1")
            .isEqualTo(expected);
    }

    @Test
    void getshipLeft() {
        boolean result =  this.game.getshipLeft();
        boolean expected = false;
        Assertions.assertThat(result).as("ship left")
            .isEqualTo(expected);
    }

    /*@Test
    void next_Shoot() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        boolean result =  this.game.getshipLeft();
        boolean expected = false;
        Assertions.assertThat(result).as("next shoot")
            .isEqualTo(expected);
        String expectedout = """
            Game end\r
            Game end\r
            """;
        Assertions.assertThat(outContent.toString()).as("output")
            .isEqualTo(expectedout);

    }*/

    /*@Test
    void ask_cell() {
        String result = this.game.ask_cell();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedout = """
            cell:\r
            """;

        Assertions.assertThat(outContent.toString()).as("output")
            .isEqualTo(expectedout);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("A1\n".getBytes());
        System.setIn(inputStream);
        Assertions.assertThat(result).as("cell")
            .isEqualTo("A1");
    }*/

    @Test
    void print_Game() {
    }
}
