// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

package balance_parenthesis;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ParenthesisBalancerTest {

    @Test
    void shouldSimpleKeyBeBalanced() {
        assertTrue(ParenthesisBalancer.isBalanced("{}"));
    }

    @Test
    void shouldSimpleParenthesisBeBalanced() {
        assertTrue(ParenthesisBalancer.isBalanced("()"));
    }

    @Test
    void shouldSimpleBracketsBeBalanced() {
        assertTrue(ParenthesisBalancer.isBalanced("[]"));
    }

    @Test
    void shouldCombinedBracketsBeBalanced() {
        assertTrue(ParenthesisBalancer.isBalanced("[[]]"));
    }

    @Test
    void shouldMixedElementsBeBalanced() {
        assertTrue(ParenthesisBalancer.isBalanced("[({})]"));
    }

    @Test
    void shouldMismatchedElementsNotBeBalanced() {
        assertFalse(ParenthesisBalancer.isBalanced("[({})]]"));
    }

    @Test
    void shouldMismatchedBracketsNotBeBalanced() {
        assertFalse(ParenthesisBalancer.isBalanced("[[]"));
    }

    @Test
    void shouldReadmeTestOneReturnNotBalanced(){
        assertFalse(ParenthesisBalancer.isBalanced("{{)(}}"));
    }

    @Test
    void shouldReadmeTest2ReturnNotBalanced(){
        assertFalse(ParenthesisBalancer.isBalanced("({)}"));
    }

    @Test
    void shouldReadmeTest3ReturnBalanced(){
        assertTrue(ParenthesisBalancer.isBalanced("[({})]"));
    }


    @Test
    void shouldReadmeTest4ReturnBalanced(){
        assertTrue(ParenthesisBalancer.isBalanced("{}([])"));
    }

    @Test
    void shouldReadmeTest5ReturnBalanced(){
        assertTrue(ParenthesisBalancer.isBalanced("{()}[[{}]]"));
    }
}
