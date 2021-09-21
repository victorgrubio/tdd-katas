import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class PrinterTest {
    
    private Printer printer = new Printer(FizzBuzz.fizzbuzz);

    @Test
    void shouldPrintOneNumber() {
        assertEquals(printer.printNumberResult(2), "2");
    }
}