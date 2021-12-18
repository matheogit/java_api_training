package fr.lernejo.navy_battle.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

class PlayerTest {
    Player player = new Player();
    @Test
    void initseatest() {
        player.Init_Sea();
        Assertions.assertThat(player.getSea()).as("init of sea")
            .isEqualTo(new String[][] {{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"}});
    }
    @Test
    void addboattest() {
        Boat boat = new Boat(1,1,1,1);
        player.Add_Boat(boat);
        ArrayList<Boat> boats = new ArrayList<>();
        boats.add(boat);
        Assertions.assertThat(player.getBoats()).as("add a boat")
            .isEqualTo(boats);
    }
    @Test
    void setboattest() {
        player.setBoat(0,0);
        Assertions.assertThat(player.getSea()).as("init of sea")
            .isEqualTo(new String[][] {{"o","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"}});
    }
    @Test
    void setshoottest() {
        player.setShoot(0,0);
        Assertions.assertThat(player.getSea()).as("init of sea")
            .isEqualTo(new String[][] {{"x","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"},{"-","-","-","-","-","-","-","-","-","-"}});
    }
    @Test
    void printseatest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        player.Init_Sea();
        player.Print_Sea();
        String expected = """
             	ABCDEFGHIJ\r
            1	----------\r
            2	----------\r
            3	----------\r
            4	----------\r
            5	----------\r
            6	----------\r
            7	----------\r
            8	----------\r
            9	----------\r
            10	----------\r
            """;
        Assertions.assertThat(outContent.toString()).as("init of sea")
            .isEqualTo(expected);
    }
}
