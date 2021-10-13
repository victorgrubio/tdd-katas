package balance_parenthesis;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;



public class ParenthesisBalancer {

    public static boolean isBalanced(String inputString) {
        boolean result = false;
        char[] charArray = inputString.toCharArray();
        Stack<Grouper> grouperStack = createGrouperStackFromCharArray(charArray);
        if (grouperStack.isEmpty()){
            result = true;
        }
        return result;
    }

    private static Stack<Grouper> createGrouperStackFromCharArray(char[] charArray) {
        Stack<Grouper> grouperStack = new Stack<>();
        IntStream.range(0, charArray.length).forEach(
                charIndex -> {
                    Character currentChar = charArray[charIndex];
                    Optional<Grouper> grouper = addGrouperFromChar(currentChar);
                    if (grouper.isPresent()) {
                        Grouper grouperValue = grouper.get();
                        processGrouperStack(grouperStack, grouperValue);
                    }
                }
        );
        return grouperStack;
    }

    private static void processGrouperStack(Stack<Grouper> grouperStack, Grouper grouper){
        if (grouperStack.isEmpty()){
            grouperStack.push(grouper);
        }
        else{
            boolean isAMatch = grouperStack.peek().matchedElements(grouper);
            if (isAMatch){
                grouperStack.pop();
            } else {
                grouperStack.push(grouper);
            }
        }
    }

    private static Optional<Grouper> addGrouperFromChar(Character currentChar) {
        Grouper result = null;
        if (currentChar == '[' || currentChar == ']'){
            result = new Bracket(currentChar);
        }
        else if (currentChar == '(' || currentChar == ')'){
            result = new Parenthesis(currentChar);
        }
        else if (currentChar == '{' || currentChar == '}'){
            result = new Key(currentChar);
        }
        return Optional.ofNullable(result);
    }
}
