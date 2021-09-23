package xmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class XMasSinger {

    private List<String> mainLyrics;
    private List<String> songStartLyrics;

    public XMasSinger(List<String> mainLyrics){
        this.mainLyrics = mainLyrics;
        this.songStartLyrics = Arrays.asList("On the", "day of Christmas", "My true love gave to me:");
    }

    public List<String> singDay(int dayNumber) throws IllegalArgumentException{
        checkValidLimitDay(dayNumber);
        List<String> sungLyrics = getStartingSongLyrics(dayNumber - 1);
        List<String> finalSungLyrics = sungLyrics;
        IntStream.range(0, dayNumber).forEach(
                dayValue -> addDayLyricsLine(finalSungLyrics, dayNumber - dayValue - 1)
        );
        if (dayNumber == mainLyrics.size()){
            sungLyrics = formatLastSentenceInLastDaySong(finalSungLyrics);
        }
        else if (dayNumber > 1){
            sungLyrics = formatPenultimateSentenceInSong(finalSungLyrics);
        }
        return sungLyrics;
    }

    private List<String> formatPenultimateSentenceInSong(List<String> sungLyrics) {

        String penultimateSentence = sungLyrics.get(sungLyrics.size() - 2);
        String formattedLastSentence = penultimateSentence.concat(" and");
        sungLyrics.set(sungLyrics.size() - 2, formattedLastSentence);
        return sungLyrics;
    }

    private List<String> formatLastSentenceInLastDaySong(List<String> sungLyrics) {
        String lastSentence = sungLyrics.get(sungLyrics.size() - 1);
        String formattedLastSentence = "And ".concat(
            lastSentence.substring(0, 1).toLowerCase() + lastSentence.substring(1)
        );
        sungLyrics.set(sungLyrics.size() - 1, formattedLastSentence);
        return sungLyrics;
    }

    private void addDayLyricsLine(List<String> sungLyrics, int dayIndex) {
        String dayLyrics = mainLyrics.get(dayIndex);
        if (dayIndex == 0){
            dayLyrics = dayLyrics.concat(".");
        }
        sungLyrics.add(dayLyrics);
    }

    private List<String> getStartingSongLyrics(int dayNumber) {
        List<String> sungLyrics = new ArrayList<>();
        String initLine = String.join(" ",
                new String[]{songStartLyrics.get(0), getOrdinalFromDayNumber(dayNumber), songStartLyrics.get(1)}
        );
        sungLyrics.addAll(List.of(new String[]{initLine, songStartLyrics.get(2)}));
        return sungLyrics;
    }

    private String getOrdinalFromDayNumber(int dayNumber) throws IllegalArgumentException{
        String[] ordinals = {
                "first", "second", "third", "fourth",
                "fifth", "sixth", "seventh", "eight",
                "ninth", "tenth", "eleventh", "Twelfth"
        };
        if (dayNumber > ordinals.length) {
            String errorMessage = String.format("dayNumber must be less than %d", ordinals.length);
            throw new IllegalArgumentException(errorMessage);
        }
        return ordinals[dayNumber];
    }

    public void setMainLyrics(List<String> mainLyrics) {
        this.mainLyrics = mainLyrics;
    }

    public List<List<String>> singAllDayUntilDay(int limitDay) throws IllegalArgumentException {
        checkValidLimitDay(limitDay);

        List<List<String>> sungUntilDayLyrics = new ArrayList<>();
        IntStream.range(1, limitDay + 1).forEach(
                dayValue -> {
                    sungUntilDayLyrics.add(singDay(dayValue));
                }
        );
        return sungUntilDayLyrics;
    }

    private void checkValidLimitDay(int limitDay) throws IllegalArgumentException {
        if (limitDay > mainLyrics.size()) throw new IllegalArgumentException(
                String.format("Invalid sing day, max value is %d", mainLyrics.size()));
    }
}
