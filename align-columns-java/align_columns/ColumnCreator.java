package align_columns;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ColumnCreator {

    private String text;

    public ColumnCreator(String text){
        this.text = text;
    }

    public static String[] splitText(String textToSplit, String regex){
        return textToSplit.split(regex);
    }

    public String[] splitText(){
        return splitText(this.text, "\n");
    }


    public String[][] multiLineSplit(String regex) {
        String[] lineSplitText = splitText();
        String[][] multiLineSplitText = Arrays.stream(lineSplitText).map(
                (String lineText) -> splitText(lineText, regex)
        ).toArray(String[][]::new);
        return multiLineSplitText;
    }

    public List<List<Integer>> getLineColumnSizes(String[][] splitTextMultiLines) {
        List<List<Integer>> lineColumnSizes = new ArrayList<>();
        IntStream.range(0, splitTextMultiLines.length).forEach(
                lineIndex -> {
                    String[] splitLine = splitTextMultiLines[lineIndex];
                    IntStream.range(0, splitLine.length).forEach(
                            columnIndex -> {
                                if (lineIndex == 0){
                                    lineColumnSizes.add(new ArrayList<>());
                                }
                                lineColumnSizes.get(columnIndex).add(splitLine[columnIndex].length());
                            });
                }
        );
        return lineColumnSizes;
    }
}
