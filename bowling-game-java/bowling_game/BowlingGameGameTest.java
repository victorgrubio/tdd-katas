package bowling_game;// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp(){
        this.bowlingGame = new BowlingGame();
    }

    @Test
    void shouldComputeSimpleTurn() {
        String turn = "81|";
        int turnResult = bowlingGame.computeTurn(turn);
        assertEquals(turnResult, 9);
    }

    @Test
    void shouldComputeMissTurn() {
        String turn = "8-|";
        int turnResult = bowlingGame.computeTurn(turn);
        assertEquals(turnResult, 8);
    }

    @Test
    void shouldComputeDoubleMissTurn() {
        String turn = "--|";
        int turnResult = bowlingGame.computeTurn(turn);
        assertEquals(turnResult, 0);
    }

    @Test
    void shouldComputeSpare(){
        String turn = "5/|";
        int turnResult = bowlingGame.computeTurn(turn);
        assertEquals(turnResult, 5);
        assertTrue(bowlingGame.isSpare());
    }

    @Test
    void shouldComputeSpareComplete(){
        String turns = "5/|5-";
        int turnResult = bowlingGame.computeTurn(turns);
        assertEquals(turnResult, 20);
        assertFalse(bowlingGame.isSpare());
    }

    @Test
    void shouldComputeStrike(){
        String turns = "X|";
        int turnResult = bowlingGame.computeTurn(turns);
        assertEquals(turnResult, 0);
        assertTrue(bowlingGame.isStrike());
    }

    @Test
    void shouldComputeStrikeComplete(){
        String turns = "X|54|";
        int turnResult = bowlingGame.computeTurn(turns);
        assertEquals(turnResult, 28);
        assertFalse(bowlingGame.isStrike());
    }
}
