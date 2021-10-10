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
        String rolls = "81|--|--|--|--|--|--|--|--|--||";
        int score = bowlingGame.computeGame(rolls);
        assertEquals(score, 9);
    }

    @Test
    void shouldComputeMissTurn() {
        String rolls = "9-|--|--|--|--|--|--|--|--|--||";
        int score = bowlingGame.computeGame(rolls);
        assertEquals(score, 9);
    }

    @Test
    void shouldComputeDoubleMissTurn() {
        String rolls = "--|--|--|--|--|--|--|--|--|--||";
        int score = bowlingGame.computeGame(rolls);
        assertEquals(score, 0);
    }

    @Test
    void shouldComputeSpareComplete(){
        String rolls = "5/|5-|--|--|--|--|--|--|--|--||";
        int score = bowlingGame.computeGame(rolls);
        assertEquals(score, 20);
    }

    @Test
    void shouldComputeStrikeComplete(){
        String rolls = "X|54|--|--|--|--|--|--|--|--|--||";
        int score = bowlingGame.computeGame(rolls);
        assertEquals(score, 28);
    }

    @Test
    void shouldComputeConsecutiveStrikes(){
        String rolls = "X|X|5-|--|--|--|--|--|--|--|--|--||";
        int score = bowlingGame.computeGame(rolls);
        assertEquals(score, 45);
   }


    @Test
    void shouldComputePerfectGame(){
        String rolls = "X|X|X|X|X|X|X|X|X|X||XX";
        int score = bowlingGame.computeGame(rolls);
        assertEquals(score, 300);
    }
}
