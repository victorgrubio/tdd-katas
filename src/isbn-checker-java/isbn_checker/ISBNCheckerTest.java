package isbn_checker;// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ISBNCheckerTest {

    @Test
    void shouldValidateISBNCode() {
        String code = "9780470059029";
        assertTrue(ISBNChecker.validateISBNCode(code));
    }

    @Test
    void shouldValidateISBNCodeWithSpaces() {
        String code = "978 0 471 48648 0";
        assertTrue(ISBNChecker.validateISBNCode(code));
    }

    @Test
    void shouldValidateISBNCodeWithDashes() {
        String code = "978-0-13-149505-0";
        assertTrue(ISBNChecker.validateISBNCode(code));
    }

    @Test
    void shouldValidateISBN10Code() {
        String code = "0471958697";
        assertTrue(ISBNChecker.validateISBNCode(code));
    }

    @Test
    void shouldValidateISBN10CodeSpaces() {
        String code = "0 471 60695 2";
        assertTrue(ISBNChecker.validateISBNCode(code));
    }

    @Test
    void shouldValidateISBN10CodeDashes() {
        String code = "0-470-84525-2";
        assertTrue(ISBNChecker.validateISBNCode(code));
    }

    @Test
    void shouldCheckInvalidLengthCode() {
        String code = "0-470-84525-21";
        assertThrows(IllegalArgumentException.class, () -> ISBNChecker.validateISBNCode(code));
    }

    @Test
    void shouldCheckInvalidSumCode() {
        String code = "0-470-84525-3";
        assertFalse(ISBNChecker.validateISBNCode(code));
    }

    @Test
    void shouldCheckInvalidContentCode() {
        String code = "0fdjsfkshf";
        assertThrows(IllegalArgumentException.class, () -> ISBNChecker.validateISBNCode(code));
    }
}
