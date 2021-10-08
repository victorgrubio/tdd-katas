package isbn_checker;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ISBNChecker {

    public static boolean validateISBNCode(String isbnCode){
        boolean result;
        AtomicInteger totalSum = new AtomicInteger();
        String strippedCode = isbnCode.replace(" ", "").replace("-", "");
        if (strippedCode.length() == 10){
            result = validateISBN10(strippedCode);
        } else if (strippedCode.length() == 13){
            result = validateISBN13(totalSum, strippedCode);
        } else {
            throw new IllegalArgumentException("isbnCode must have 10 or 13 digits");
        }
        return result;

    }

    private static boolean validateISBN13(AtomicInteger totalSum, String strippedCode) {
        IntStream.range(0, strippedCode.length()).forEach(
                charIndex -> isbn13Adder(strippedCode, totalSum, charIndex)
        );
        return (totalSum.get() % 10) == 0;
    }

    private static void isbn13Adder(String strippedCode, AtomicInteger totalSum, int charIndex) {
        int charValue = Character.getNumericValue(strippedCode.charAt(charIndex));
        int multiplier = 1;
        if (charIndex % 2 != 0) {
            multiplier = 3;
        }
        totalSum.addAndGet(multiplier*charValue);
    }

    private static boolean validateISBN10(String strippedCode){
        AtomicInteger totalSum = new AtomicInteger(0);
        IntStream.range(0, strippedCode.length() - 1).forEach(
                charIndex -> isbn10Adder(strippedCode, totalSum, charIndex)
        );
        return validateISBN10Sum(totalSum, strippedCode.charAt(strippedCode.length() - 1));
    }

    private static boolean validateISBN10Sum(AtomicInteger totalSum, char controlDigit) {
        int charValue;
        if (controlDigit == 'X'){
            charValue = 10;
        } else {
            charValue = Character.getNumericValue(controlDigit);
        }
        return (charValue == (totalSum.get()) % 11);
    }

    private static void isbn10Adder(String strippedCode, AtomicInteger totalSum, int charIndex) {
        int charValue = getCharValue(strippedCode.charAt(charIndex));
        totalSum.addAndGet((charIndex+1)*charValue);
    }

    private static int getCharValue(char charAt) {
        if (!Character.isDigit(charAt)){
            throw new IllegalArgumentException("Code should not have any char except for the last one in ISBN10");
        }
        return Character.getNumericValue(charAt);
    }
}
