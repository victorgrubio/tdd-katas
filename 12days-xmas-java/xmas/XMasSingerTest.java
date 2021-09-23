// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/
package xmas;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class XMasSingerTest {

    private List<String> lyrics;
    private XMasSinger xmasSinger;

    @BeforeEach
    void setUp(){
        lyrics = Arrays.asList(
                "A partridge in a pear tree",
                "Two turtle doves",
                "Three french hens",
                "Four calling birds",
                "Five golden rings",
                "Six geese a-laying",
                "Seven swans a-swimming",
                "Eight maids a-milking",
                "Nine ladies dancing",
                "Ten lords a-leaping",
                "Eleven pipers piping",
                "Twelve drummers drumming"
        );
        xmasSinger = new XMasSinger(lyrics);
    }

    @Test
    void shouldReturnFirstDayLyrics() {
        int limitDay = 1;
        List<String> sungDayLyrics = xmasSinger.singDay(limitDay);
        assertEquals(sungDayLyrics.size(), limitDay + 2);
        assertEquals(sungDayLyrics, Arrays.asList(
                "On the first day of Christmas",
                "My true love gave to me:",
                lyrics.get(0).concat(".")
        ));
    }

    @Test
    void shouldThrowIllegalArgumentErrorOnSing() {
        int limitDay = lyrics.size() + 1;
        assertThrows(IllegalArgumentException.class, () -> {
            xmasSinger.singDay(limitDay);
        });
    }

    @Test
    void shouldReturnDayIterativeLyrics(){
        int limitDay = 2;
        List<String> sungDayLyrics = xmasSinger.singDay(limitDay);
        assertEquals(sungDayLyrics.size(), limitDay + 2);
        assertEquals(sungDayLyrics, Arrays.asList(
                "On the second day of Christmas",
                "My true love gave to me:",
                lyrics.get(1),
                lyrics.get(0).concat(".")
        ));
    }

    @Test
    void shouldReturnAllDaysUntilGivenDay(){
        int limitDay = 3;
        List<List<String>> sungDayIterationLyrics = xmasSinger.singAllDayUntilDay(limitDay);
        assertEquals(sungDayIterationLyrics.size(), 3);
        assertEquals(sungDayIterationLyrics.get(limitDay - 1).size(), limitDay + 2);
        assertEquals(sungDayIterationLyrics.get(limitDay - 2).size(), limitDay + 2 - 1);
    }


    @Test
    void shouldThrowIllegalArgumentErrorLoopSing() {
        int limitDay = lyrics.size() + 1;
        assertThrows(IllegalArgumentException.class, () -> {
            xmasSinger.singAllDayUntilDay(limitDay);
        });
    }
}
