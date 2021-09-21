import java.lang.reflect.Method;


public class Printer {
 
    
    public Printer(Method function){
        this.function = function;
    }
    
    public void printNumberResult(int number){
        System.out.println(this.function(number));
    }
    
    public void printNumberRangeResult(int initRange, int endRange){
        for (int i = initRange; i <= endRange; i++){
            this.printNumberResult(i);
        }
    }
    
    public void printNumberRangeResult(int endRange){
        this.printNumberRangeResult(0, endRange);
    }
    
}