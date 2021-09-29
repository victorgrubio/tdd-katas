package align_columns;// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class ColumnCreatorTest {

    public static String dollarText = "Given$a$text$file$of$many$lines,$where$fields$within$a$line$\n" +
    "are$delineated$by$a$single$'dollar'$character,$write$a$program\n" +
    "that$aligns$each$column$of$fields$by$ensuring$that$words$in$each$\n" +
    "column$are$separated$by$at$least$one$space.";

    private String[][] splitMultiLines = {
            {"A", "B"},
            {"AA", "BB"}
    };

    private String[][] splitMultiLinesDifferentLengths = {
            {"A", "B"},
            {"AA", "BB", "C"}
    };

    private ColumnCreator columnCreator;

    @BeforeEach
    void setUp(){
        columnCreator = new ColumnCreator(dollarText);
    }

    @Test
    void shouldSplitSentencesByLine() {
        String[] splitText = columnCreator.splitText();
        assertEquals(splitText.length, 4);
    }

    @Test
    void shouldSplitLineByDollarSigns(){
        String[] splitText = columnCreator.splitText();
        String[] splitLineText = columnCreator.splitText(splitText[0], Pattern.quote("$"));
        assertEquals(splitLineText.length, 12);
    }

    @Test
    void shouldSplitMultipleLinesByDollarSigns(){
        String[][] multiLineSplitText = columnCreator.multiLineSplit(Pattern.quote("$"));
        assertEquals(multiLineSplitText.length, 4);
        assertEquals(multiLineSplitText[0].length, 12);
    }

    @Test
    void shouldReturnColumnSizeOfLines(){
        List<Integer> array1 = List.of(new Integer[]{1, 2});
        List<List<Integer>> columnSizes = columnCreator.getLineColumnSizes(splitMultiLines);
        assertEquals(columnSizes.size(), 2);
        assertEquals(columnSizes.get(0), array1);
    }

    @Test
    void shouldUpdateColumnsBasedOnSize(){
        String[][] exampleUpdatedColumns = new String[][]{
                {
                    "A  ", "B  "
                },
                {
                    "AA ", "BB "
                }
        };
        String[][] updatedColumns = columnCreator.createColumns(splitMultiLines);
        assertEquals(updatedColumns[0][0].length(), updatedColumns[1][0].length());
        IntStream.range(0, exampleUpdatedColumns.length).forEach(
                exampleIndex -> {
                    assertArrayEquals(exampleUpdatedColumns[exampleIndex], updatedColumns[exampleIndex]);
                }
        );
    }

    @Test
    void shouldReturnColumnsWithArraysOfDifferentLengths(){
        String[][] exampleUpdatedColumns = new String[][]{
                {
                        "A  ", "B  "
                },
                {
                        "AA ", "BB ", "C "
                }
        };
        String[][] updatedColumns = columnCreator.createColumns(splitMultiLinesDifferentLengths);
        assertEquals(updatedColumns[0][0].length(), updatedColumns[1][0].length());
        assertEquals(updatedColumns[1][2].length(), 2);
    }
}
