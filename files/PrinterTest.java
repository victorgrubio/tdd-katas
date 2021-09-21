import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class PrinterTest {
    
    public Printer printer = new Printer(FizzBuzz.fizzbuzz);
    public ArrayList<String>displayed = new ArrayList<String>();
    public String lastDisplay = "";

    @Test
    void shouldPrintOneNumber() {
        printer.printNumberResult(2, this.display);
        assertEquals(lastDisplay, "2");
    }
    
    public void display(String text){
        displayed.add(text);
        lastDisplay = text;
    }
}