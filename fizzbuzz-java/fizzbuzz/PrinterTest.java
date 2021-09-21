import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;


public class PrinterTest {
    
    public Printer printer = new Printer();
    public ArrayList<String> displayed = new ArrayList<>();

    @Test
    public void shouldPrintOneNumber() {
        printer.printNumberResult(2, displayed);
        assertEquals(getLastDisplay(), "2");
        displayed.clear();
    }
    
    @Test
    public void shouldPrintNumberRangeWithEndOnly(){
        printer.printNumberRangeResult(100, displayed);
        assertEquals(getLastDisplay(), "Buzz");
        assertEquals(getDisplayElement(15), "FizzBuzz");
    }

    public String getLastDisplay(){
        String result = "";
        if (displayed.size() > 0) {
            result = displayed.get(displayed.size() - 1);
        }
        return result;
    }

    public String getDisplayElement(int index){
        return displayed.get(index);
    }
}