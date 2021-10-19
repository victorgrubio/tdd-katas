package array_shuffle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ShufflerTest {

    @Test
    void shouldReturnRandomNumber(){
        int length = 9;
        int minValue = 1;
        int random = Shuffler.getRandomValueFromRange(minValue, length);
        assertTrue(random < length);
        assertTrue(random >= minValue);
    }

    @Test
    void shouldThrowIllegalArgumentIfValueLessThanZero(){
        assertThrows(IllegalArgumentException.class, () -> {
            Shuffler.getRandomValueFromRange(-1);
        });
    }

    @Test
    void shouldThrowIllegalArgumentIfMinValueOverMaxValue(){
        assertThrows(IllegalArgumentException.class, () -> {
            Shuffler.getRandomValueFromRange(1, 0);
        });
    }

    @Test
    void twoDigitsArrayShuffler(){
        int[] array = {-1, -2, -3, -4, -5, -6};
        int[] arrayOriginal = array.clone();
        int[] shuffledArray = Shuffler.shuffleArray(array);
        assertFalse(Arrays.equals(array, shuffledArray));
        assertTrue(Arrays.equals(array, arrayOriginal));
    }
}
