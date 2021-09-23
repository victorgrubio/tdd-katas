package xmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrinterTest {

    private List<String> lyrics;
    private XMasSinger xmasSinger;
    public Printer printer;
    private List<List<String>> displayed = new ArrayList<>();

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
        printer = new Printer(xmasSinger);
    }

    @Test
    public void shouldPrintOneDaySing() {
        int dayNumber = 4;
        printer.printOneDaySing(dayNumber, displayed);
        assertEquals(displayed.size(), 1);
    }

    @Test
    public void shouldPrintAllDaysIterativeSing(){
        int dayNumber = lyrics.size();
        printer.printIterativeSing(dayNumber, displayed);
        assertEquals(displayed.size(), dayNumber);
        assertEquals(displayed.get(lyrics.size() - 1).size(), lyrics.size() + 2);
    }
}