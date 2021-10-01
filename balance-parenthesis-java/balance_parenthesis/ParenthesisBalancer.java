package balance_parenthesis;
import java.util.Stack;
import java.util.stream.IntStream;



public class ParenthesisBalancer {

    public static boolean isBalanced(String inputString) {
        boolean result = false;
        char[] charArray = inputString.toCharArray();
        Stack<Character> charStack = new Stack<Character>();
        IntStream.range(0, charArray.length).forEach(
                charIndex -> {
                    Character currentChar = charArray[charIndex];

                }
        );
        return result;
    }
}
