import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import FizzBuzz.fizzbuzz;

public class PrinterTest {
    
    public Printer printer = new Printer(FizzBuzz.fizzbuzz);
    public String[] displayed = {};
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