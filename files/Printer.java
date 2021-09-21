import java.lang.reflect.Method;
import java.util.ArrayList;


public class Printer {
    
    Method function;
    
    public Printer(){
        this.function = FizzBuzz.fizzbuzz;
    }
 
    
    public void printNumberResult(int number, ArrayList<String> displayed){
        // TODO: pass function in constructor
        String displayText = this.function(number);
        System.out.println(displayText);
        displayed.add(displayText);
    }
    
    public void printNumberRangeResult(int initRange, int endRange, ArrayList<String> displayed){
        for (int i = initRange; i <= endRange; i++){
            this.printNumberResult(i, displayed);
        }
    }
    
    public void printNumberRangeResult(int endRange, ArrayList<String> displayed){
        this.printNumberRangeResult(0, endRange, displayed);
    }
    
}