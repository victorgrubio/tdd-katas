import java.lang.reflect.Method;


public class Printer {
    
    private Method function;
 
    
    public Printer(Method function){
        this.function = function;
    }
    
    public void printNumberResult(int number, Method displayFunction){
        String displayText = this.function(number);
        displayFunction(displayText);
        System.out.println(displayText);
    }
    
    public void printNumberRangeResult(int initRange, int endRange, Method displayFunction){
        for (int i = initRange; i <= endRange; i++){
            this.printNumberResult(i, displayFunction);
        }
    }
    
    public void printNumberRangeResult(int endRange, Method displayFunction){
        this.printNumberRangeResult(0, endRange, displayFunction);
    }
    
}