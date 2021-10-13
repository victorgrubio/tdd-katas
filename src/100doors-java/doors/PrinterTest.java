package doors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrinterTest {
    
    public Printer printer = new Printer();
    private List<Boolean> doorStatusArray = Arrays.asList(new Boolean[100]);
    private List<String> displayed = new ArrayList<>();

    @BeforeEach
    void setUp(){
        doorStatusArray = doorStatusArray.stream().map(
                doorStatus -> {return false;}
        ).collect(Collectors.toList());
    }

    @Test
    public void shouldPrintIterationResult() {
        printer.printIterationResult(doorStatusArray, doorStatusArray.size(), displayed);
        assertEquals(displayed.size(), doorStatusArray.size());
    }
}