import java.lang.reflect.Method;


public class Printer {
 
    
    public Printer(Method function){
        this.function = function;
    }
    
    public void printNumberResult(int number){
        System.out.println(this.function(number));
    }
    
    public void printNumberRangeResult(int initRange = 0, int endRange = 0){
        for (int i = initRange; i <= endRange; i++){
            this.printNumberResult(i);
        }
    }
    
}