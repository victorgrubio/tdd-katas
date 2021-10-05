package bowling_game;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

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

    public int computeTurn(String turn){
        String[] turnScores = turn.split(Pattern.quote("|"));
        int result = Arrays.stream(turnScores).map(
                this::computeScore
        ).reduce(0, Integer::sum);
        return result;
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
        AtomicBoolean currentSpare = new AtomicBoolean(false);
        AtomicBoolean currentStrike = new AtomicBoolean(false);
        return IntStream.range(0, splitTurnPoints.length).map(
                turnIndex -> {
                    String turnPoint = splitTurnPoints[turnIndex];
                    int result = 0;
                    switch (turnPoint){
                        case "-":
                            break;
                        case "/":
                            setSpare(true);
                            currentSpare.set(true);
                            break;
                        case "X":
                            setStrike(true);
                            currentStrike.set(true);
                            break;
                        default:
                            result += Integer.parseInt(turnPoint);
                    }
                    if (isSpare() && !currentSpare.get()){
                        result += 10;
                        setSpare(false);
                    }
                    return result;
                }
        ).reduce(0, (turnResult, resultValue) -> {
            int finalResult = turnResult + resultValue;
            if (isStrike() && !currentStrike.get()){
                finalResult += 10;
                setStrike(false);
            }
            return finalResult;
        });
    }
}
