package fizzbuzz;// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void shouldReturnStringForNumber() {
        assertEquals(FizzBuzz.fizzbuzz(2), "2");
    }
    
    @Test
    public void shouldReturnFizzForThree(){
        assertEquals(FizzBuzz.fizzbuzz(3), "Fizz");
    }
    
    @Test
    public void shouldReturnBuzzForFive(){
        assertEquals(FizzBuzz.fizzbuzz(5), "Buzz");   
    }
    
    @Test
    public void shouldReturnFizzForThreeMultiple(){
        assertEquals(FizzBuzz.fizzbuzz(9), "Fizz");
    }
    
    @Test
    public void shouldReturnBuzzForFiveMultiple(){
        assertEquals(FizzBuzz.fizzbuzz(25), "Buzz");
    }
    
    @Test
    public void shouldReturnFizzBuzzForFiveThreeMultiple(){
        assertEquals(FizzBuzz.fizzbuzz(15), "FizzBuzz");
    }
}
