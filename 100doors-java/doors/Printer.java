package doors;
import java.util.List;


public class Printer {
    
        
    public void printIterationResult(List<Boolean> doorStatusArray, int iterations, List<String> displayed){
        DoorManager.alterDoors(doorStatusArray, iterations).stream().forEach(
                doorStatus -> {
                    displayed.add(String.valueOf(doorStatus));
                    System.out.println(doorStatus);
                }
        );
    }
    
}