import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class PrinterTest {
    
    private Printer printer = new Printer(FizzBuzz.fizzbuzz);
    public String[] displayed = {};
    public String lastDisplay = "";

    @Test
    void shouldPrintOneNumber() {
        printer.printNumberResult(2, this.display)
        assertEquals(lastDisplay, "2");
    }
    
    public void Display(String text){
        displayed.add(text);
        lastDisplay = text;
    }
}