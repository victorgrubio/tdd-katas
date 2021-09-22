// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

package doors;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoorManagerTest {

    private List<Boolean> doorStatusArray = Arrays.asList(new Boolean[100]);

    @BeforeEach
    void setUp(){
        doorStatusArray = doorStatusArray.stream().map(
                doorStatus -> {return false;}
        ).collect(Collectors.toList());
    }

    static boolean closeDoor(Boolean doorStatus){
        doorStatus = false;
        return doorStatus;
    }

    @Test
    void testShouldAllDoorsBeClosed(){
        assertEquals(doorStatusArray.stream().allMatch(doorStatus -> doorStatus == false), true);
    }

    @Test
    void testShouldAllTrueAfterDoOneIteration(){
        doorStatusArray = DoorManager.alterDoors(doorStatusArray, 1);
        assertEquals(doorStatusArray.stream().allMatch(doorStatus -> doorStatus == true), true);
    }

    @Test
    void testShouldHalfDoorsBeTrueAfter2Iterations(){
        doorStatusArray = DoorManager.alterDoors(doorStatusArray, 2);
        assertEquals(countBooleanItems(doorStatusArray, true), doorStatusArray.size() / 2);
        assertEquals(countBooleanItems(doorStatusArray, false), doorStatusArray.size() / 2);
        assertEquals(doorStatusArray.get(0), true);
        assertEquals(doorStatusArray.get(1), false);
    }

    @Test
    void testShouldRunIterationsEqualToArraySize(){
        doorStatusArray = DoorManager.alterDoors(doorStatusArray, doorStatusArray.size());
        assertTrue(doorStatusArray.get(doorStatusArray.size()-1) instanceof Boolean);
    }

    @Test
    void testShould6thDoorBeOpenedAfter3Iterations(){
        doorStatusArray = DoorManager.alterDoors(doorStatusArray, 3);
        assertEquals(doorStatusArray.get(6), true);
    }


    int countBooleanItems(List<Boolean> booleanArray, boolean status){
        return (int)booleanArray.stream()
                .filter(item -> item!=null && item==status)
                .count();
    }
}
