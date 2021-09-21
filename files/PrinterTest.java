import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class PrinterTest {
    
    public Printer printer = new Printer(FizzBuzz.fizzbuzz);
    public ArrayList<String>displayed = new ArrayList<String>();

    @Test
    void shouldPrintOneNumber() {
        printer.printNumberResult(2, displayed);
        assertEquals(lastDisplay, "2");
    }
    
    public String getLastDisplay(){
        String result = ""
        if (displayed.size() > 0) {
            result = displayed.get(displayed.size() - 1);
        return result;
    
    }
}