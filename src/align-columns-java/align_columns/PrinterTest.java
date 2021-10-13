package align_columns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrinterTest {
    
    public Printer printer;
    private String[][] multiLineSplitText;
    private List<String> displayed = new ArrayList<>();

    @BeforeEach
    void setUp(){
        ColumnCreator columnCreator = new ColumnCreator(ColumnCreatorTest.dollarText);
        printer = new Printer(columnCreator);
        multiLineSplitText = columnCreator.multiLineSplit(ColumnCreatorTest.dollarText, Pattern.quote("$"));
    }


    @Test
    public void shouldPrintMultiLineSplitText() {
        printer.printSplitText(multiLineSplitText, displayed);
        assertEquals(displayed.size(), getMatrixCellNumber(multiLineSplitText));
    }

    private int getMatrixCellNumber(String[][] multiLineSplitText) {
        AtomicInteger matrixCellNumber = new AtomicInteger();
        Arrays.stream(multiLineSplitText).forEach(
                lineSplit -> {
                    matrixCellNumber.set(matrixCellNumber.get() + lineSplit.length);
                }
        );
        return matrixCellNumber.get();
    }
}