package align_columns;

import java.util.Arrays;
import java.util.List;


public class Printer {

    private ColumnCreator columnCreator;

    public Printer(ColumnCreator columnCreator){
        this.columnCreator = columnCreator;
    }

    public void printSplitText(String[][] multiLineSplitText, List<String> displayed) {
        String[][] updateText = columnCreator.createColumns(multiLineSplitText);
        Arrays.stream(updateText).forEach(
                lineSplitUpdate -> {
                    Arrays.stream(lineSplitUpdate).forEach(
                            columnText -> {
                                System.out.print(columnText);
                                displayed.add(columnText);
                            }
                    );
                    System.out.println();
                }
        );
    }
}