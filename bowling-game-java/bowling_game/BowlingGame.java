package bowling_game;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class BowlingGame {

    private int[] rolls = new int[23];
    private int roll = 0;
    private String[] bowlingTurns;

    public BowlingGame(String turns){
        createRollsFromString(turns);
    }

    public BowlingGame(){}

    public void createRollsFromString(String rolls){
        bowlingTurns = rolls.split(Pattern.quote("|"));
    }

    public int computeGame(String turns){
        createRollsFromString(turns);
        computeRolls();
        return calculateScore();
    }

    public void computeRolls(){
        IntStream.range(0, bowlingTurns.length).forEach(
                turnIndex -> {
                    String currentRoll = bowlingTurns[turnIndex];
                    if(currentRoll.isBlank()){
                    } else if(isStrikeString(currentRoll)) {
                        rolls[roll] = 10;
                        roll++;
                    } else {
                        computeCommonTurn(currentRoll);
                    }
                }
        );
    }

    private void computeCommonTurn(String currentRoll) {
        String[] turnRolls = currentRoll.split("");
        Arrays.stream(turnRolls).forEach(
                turnRoll -> {
                    if(isStrikeString(turnRoll)){
                        rolls[roll] = 10;
                    }
                    else if(isSpareString(turnRoll)){
                        rolls[roll] = 10 - rolls[roll-1];
                    } else if (isMissString(turnRoll)){
                        rolls[roll] = 0;
                    }
                    else {
                        rolls[roll] = Integer.parseInt(turnRoll);
                    }
                    roll++;
                }
        );
    }

    public int calculateScore(){
        AtomicInteger score = new AtomicInteger(0);
        AtomicInteger bowlingCursor = new AtomicInteger(0);
        IntStream.range(0, 10).forEach(
                turnIndex -> {
                    score.set(computeTurnScore(score, bowlingCursor, turnIndex));
                }
        );
        return score.get();
    }

    private int computeTurnScore(AtomicInteger score, AtomicInteger bowlingCursor, int turnIndex) {
        if(isStrikeString(bowlingTurns[turnIndex])){
            score.addAndGet(10 + rolls[bowlingCursor.get() + 1] + rolls[bowlingCursor.get()+2]);
            bowlingCursor.incrementAndGet();
        } else if (isSpareString(bowlingTurns[turnIndex])){
            score.addAndGet(10 + rolls[bowlingCursor.get() + 1]);
            bowlingCursor.addAndGet(2);
        } else {
            score.getAndAdd(rolls[bowlingCursor.get()] + rolls[bowlingCursor.get() +1]);
            bowlingCursor.addAndGet(2);
        }
        return score.get();
    }

    private boolean isStrikeString(String bowlingGameTurn) {
        return bowlingGameTurn.equals("X");
    }

    private boolean isSpareString(String bowlingGameTurn){
        return bowlingGameTurn.contains("/");
    }

    private boolean isMissString(String bowlingGameTurn){
        return bowlingGameTurn.equals("-");
    }
}
