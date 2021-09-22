package doors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DoorManager {

    public static List<Boolean> alterDoors(List<Boolean> doorStatusArray, int iterations) {
        for (int i = 1; i <= iterations; i++){
            int currentIteration = i;
            IntStream.range(0, doorStatusArray.size())
                    .filter(x -> (x+1) % currentIteration == 0).forEach(
                            (int x) -> {
                                doorStatusArray.set(x, !doorStatusArray.get(x));
                            }
                    );
        }
        return doorStatusArray;
    }
}
