import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;

public class PrinterTest {
    
    private Printer printer = new Printer(FizzBuzz.fizzbuzz);

    @Test
    void shouldPrintOneNumber() {
        assertEquals(printer.printNumberResult(2), "2");
    }
}