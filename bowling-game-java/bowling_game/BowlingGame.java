package bowling_game;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum BowlingTurnPoints {
    SPARE(10),
    STRIKE(20);

    private final int points;
    BowlingTurnPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}

public class BowlingGame {

    private int currentScore = 0;
    private boolean isStrike = false;
    private boolean isSpare = false;
    private int[] scoreHistory;

    public BowlingGame(int gameLength){
        scoreHistory = new int[gameLength];
    }

    public BowlingGame(){
        scoreHistory = new int[10];
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public int computeTurns(String turns){
        String[] bowlingGameTurns = turns.split(Pattern.quote("|"));
        int[] turnScores = new int[bowlingGameTurns.length];
        AtomicBoolean previousStrike = new AtomicBoolean(false);
        AtomicInteger currentScore = new AtomicInteger(0);
        IntStream.range(0, turnScores.length).forEach(
            turnIndex -> {
                String[] splitBowlingTurns = bowlingGameTurns[turnIndex].split("");;
                if (splitBowlingTurns.length == 0) throw new IllegalArgumentException("Invalid turn values");
                if (splitBowlingTurns.length == 1 && splitBowlingTurns[0] == "X"){
                    if (isStrike){
                        previousStrike.set(true);
                        currentScore.getAndAdd(10);
                    }
                    setStrike(true);

                }
            }
        );
        return Arrays.stream(turnScores).sum();
    }

    private int computeScore(String stringScore) {
        int result = 0;
        if (stringScore.isBlank()){}
        else{
            result = computeIndividualBowling(stringScore.split(""));
        }
        return result;
    }

    private int computeIndividualBowling(String[] splitTurnPoints) {
        int result;
        if (splitTurnPoints.length == 1 && splitTurnPoints[0] == "X"){
            BowlingTurnPoints status = BowlingTurnPoints.STRIKE;
            result = status.getPoints();
        } else if (splitTurnPoints[1] == "/"){

        }
    }
}
