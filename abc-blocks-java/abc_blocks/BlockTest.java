package abc_blocks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTest {

    @Test
    void shouldCreateBlockFromTuple(){
        Block block = new Block("A", "B");
        assertEquals(block.left(), "A");
        assertEquals(block.right(), "B");
    }
}
