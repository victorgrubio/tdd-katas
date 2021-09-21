// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FizzBuzzTest {

    @Test
    void shouldReturnStringForNumber() {
        assertEquals(FizzBuzz.fizzbuzz(2), "2");
    }
    
    @Test
    void shouldReturnFizzForThree(){
        assertEquals(FizzBuzz.fizzbuzz(3), "Fizz");
    }
    
    @Test
    void shouldReturnBuzzForFive(){
        assertEquals(FizzBuzz.fizzbuzz(5), "Buzz");   
    }
    
    @Test
    void shouldReturnFizzForThreeMultiple(){
        assertEquals(FizzBuzz.fizzbuzz(9), "Fizz");
    }
    
    @Test
    void shouldReturnBuzzForFiveMultiple(){
        assertEquals(FizzBuzz.fizzbuzz(25), "Buzz");
    }
    
    @Test
    void shouldReturnFizzBuzzForFiveThreeMultiple{
        assertEquals(FizzBuzz.fizzbuzz(15), "FizzBuzz");
    }
}
