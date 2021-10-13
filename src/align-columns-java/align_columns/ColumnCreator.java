package align_columns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ColumnCreator {

    private String text;

    public ColumnCreator(String text){
        this.text = text;
    }

    public static String[] splitText(String textToSplit, String regex){
        return textToSplit.split(regex);
    }

    public String[] splitText(String textToSplit){
        return splitText(textToSplit, "\n");
    }
    public String[] splitText(){
        return splitText(this.text, "\n");
    }

    public String[][] multiLineSplit(String text, String regex) {
        String[] lineSplitText = splitText(text);
        String[][] multiLineSplitText = Arrays.stream(lineSplitText).map(
                (String lineText) -> splitText(lineText, regex)
        ).toArray(String[][]::new);
        return multiLineSplitText;
    }

    public String[][] multiLineSplit(String regex) {
        return multiLineSplit(text, regex);
    }

    public List<List<Integer>> getLineColumnSizes(String[][] splitTextMultiLines) {
        List<List<Integer>> lineColumnSizes = new ArrayList<>();
        IntStream.range(0, splitTextMultiLines.length).forEach(
                lineIndex -> getLineSizesFromColumns(lineColumnSizes, splitTextMultiLines[lineIndex], lineIndex)
        );
        return lineColumnSizes;
    }

    private void getLineSizesFromColumns(
            List<List<Integer>> lineColumnSizes, String[] splitTextLine, int lineIndex
    ) {
        IntStream.range(0, splitTextLine.length).forEach(
                columnIndex -> addSizeToColumn(lineIndex, lineColumnSizes, columnIndex, splitTextLine));
    }

    private void addSizeToColumn(
            int lineIndex,
            List<List<Integer>> lineColumnSizes,
            int columnIndex,
            String[] splitTextLine
    ) {
        if (lineIndex == 0){
            lineColumnSizes.add(new ArrayList<>());
        }
        lineColumnSizes.get(columnIndex).add(splitTextLine[columnIndex].length());
    }

    public String[][] createColumns(String[][] splitMultiLines) {
        AtomicInteger maxModifiedIndex = new AtomicInteger();
        IntStream.range(0, splitMultiLines.length).forEach(
                lineIndex -> {
                    int currentMaxIndex = updateColumnSizes(splitMultiLines, lineIndex, maxModifiedIndex.get());
                    maxModifiedIndex.set(Math.max(maxModifiedIndex.get(), currentMaxIndex + 1));
                }
        );
        return splitMultiLines;
    }

    private int updateColumnSizes(String[][] splitMultiLines, int lineIndex, int maxModifiedIndex) {
        AtomicInteger currentMaxIndex = new AtomicInteger();
        IntStream.range(maxModifiedIndex, splitMultiLines[lineIndex].length).forEach(
                columnIndex -> {
                    int maxColumnLength = getMaxColumnLength(splitMultiLines, columnIndex);
                    updateColumnText(splitMultiLines, columnIndex, maxColumnLength);
                    currentMaxIndex.set(Math.max(currentMaxIndex.get(), columnIndex));
                });
        return currentMaxIndex.get();
        }

    private int getMaxColumnLength(String[][] splitMultiLines, int columnIndex) {
        AtomicInteger maxColumnLength = new AtomicInteger();
        Arrays.stream(splitMultiLines).forEach(
                splitLine -> {
                    if (splitLine.length > columnIndex){
                        maxColumnLength.set(Math.max(maxColumnLength.get(), splitLine[columnIndex].length() + 1));
                    }
                }
        );
        return maxColumnLength.get();
    }


    private void updateColumnText(String[][] splitMultiLines, int columnIndex, int maxColumnLength) {
        Arrays.stream(splitMultiLines).forEach(
                splitLine -> {
                    if (splitLine.length > columnIndex){
                        String currentColumn = splitLine[columnIndex];
                        if(currentColumn.length() < maxColumnLength){
                            currentColumn = String.format("%-" + maxColumnLength + "s", currentColumn);
                            splitLine[columnIndex] = currentColumn;
                        }
                    }
                }
        );
    }
}
