package array_shuffle;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Shuffler {

    public static int getRandomValueFromRange(int minValue, int maxValue) throws IllegalArgumentException{
        if (minValue >= maxValue){
            throw new IllegalArgumentException("Min value should be lower than maxValue");
        }
        if (maxValue < 1){
            throw new IllegalArgumentException("Invalid length value. It should be more than 1");
        }
        int result = (int)Math.floor(Math.random()*(maxValue-minValue+1)+(minValue));
        if (result == maxValue){
            result -= 1;
        }
        return result;
    }

    public static int getRandomValueFromRange(int maxValue) throws IllegalArgumentException{
        return getRandomValueFromRange(0, maxValue);
    }

    public static int[] shuffleArray(int[] array) {
        int[] resultArray = array.clone();
        IntStream.range(0, array.length).forEach(
                index -> shuffleArrayElements(array, resultArray, index)
        );
        return resultArray;
    }

    private static void shuffleArrayElements(int[] array, int[] resultArray, int index) {
        int aux;
        int shuffledIndex = getRandomValueFromRange(index, array.length);
        aux = resultArray[index];
        resultArray[index] = resultArray[shuffledIndex];
        resultArray[shuffledIndex] = aux;
    }
}
