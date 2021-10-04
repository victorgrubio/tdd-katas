package balance_parenthesis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrouperTest {

    @Test
    void shouldTestBrackets(){
        Bracket grouper1 = new Bracket('[');
        Bracket grouper2 = new Bracket(']');
        assertTrue(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestMismatchedBracketsOpen(){
        Bracket grouper1 = new Bracket('[');
        Bracket grouper2 = new Bracket('[');
        assertFalse(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestMismatchedBracketsClose(){
        Bracket grouper1 = new Bracket(']');
        Bracket grouper2 = new Bracket(']');
        assertFalse(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestMismatchedBracketsCloseOpen(){
        Bracket grouper1 = new Bracket(']');
        Bracket grouper2 = new Bracket('[');
        assertFalse(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestParenthesisEnum(){
        Parenthesis open = new Parenthesis('(');
        Parenthesis close = new Parenthesis(')');
        assertTrue(open.matchedElements(close));
    }


    @Test
    void shouldTestMismatchedParenthesisOpen(){
        Parenthesis grouper1 = new Parenthesis('(');
        Parenthesis grouper2 = new Parenthesis('(');
        assertFalse(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestMismatchedParenthesisClose(){
        Parenthesis grouper1 = new Parenthesis(')');
        Parenthesis grouper2 = new Parenthesis(')');
        assertFalse(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestMismatchedParenthesisCloseOpen(){
        Parenthesis grouper1 = new Parenthesis(')');
        Parenthesis grouper2 = new Parenthesis('(');
        assertFalse(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestKeysEnum(){
        Key open = new Key('{');
        Key close = new Key('}');
        assertTrue(open.matchedElements(close));
    }


    @Test
    void shouldTestMismatchedKeysOpen(){
        Key grouper1 = new Key('{');
        Key grouper2 = new Key('{');
        assertFalse(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestMismatchedKeysClose(){
        Key grouper1 = new Key('}');
        Key grouper2 = new Key('}');
        assertFalse(grouper1.matchedElements(grouper2));
    }

    @Test
    void shouldTestMismatchedKeysCloseOpen(){
        Key grouper1 = new Key('}');
        Key grouper2 = new Key('{');
        assertFalse(grouper1.matchedElements(grouper2));
    }
}
