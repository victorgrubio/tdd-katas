package abc_blocks;// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BlockCombinerTest {

    private List<Block> blockList = new ArrayList<>();
    private List<String> blockStringList = new ArrayList<>();
    private BlockCombiner blockCombiner;

    @BeforeEach
    void setUp(){
        blockStringList.addAll(Arrays.asList(
                "B O",
                "X K",
                "D Q",
                "C P",
                "N A",
                "G T",
                "R E",
                "T G",
                "Q D",
                "F S",
                "J W",
                "H U",
                "V I",
                "A N",
                "O B",
                "E R",
                "F S",
                "L Y",
                "P C",
                "Z M"
            )
        );
        blockStringList.stream().forEach(blockContent -> {
            String[] splitString = blockContent.split(" ", 2);
            Block block = new Block(splitString[0], splitString[1]);
            blockList.add(block);
        });
        blockCombiner = new BlockCombiner(blockList);
    }

    @Test
    void shouldCreateBlockCombinerFromBlockList(){
        assertEquals(blockCombiner.getTotalBlocks(), blockStringList.size());
    }

    @Test
    void shouldFindCharStringInBlockList(){
        String charString = "A";
        assertTrue(blockCombiner.anyBlockMatch(charString));
    }

    @Test
    void shouldFindCharIfLowerCase(){
        String charString = "a";
        assertTrue(blockCombiner.anyBlockMatch(charString));
    }

    @Test
    void shouldWordWithMatchingBlock(){
        String charString = "HU";
        Optional<Block> blockFound = blockCombiner.findBlockMatch(charString);
        assertFalse(blockFound.isEmpty());
    }

    @Test
    void shouldWordWithMatchingBlockInverse(){
        String charString = "UH";
        Optional<Block> blockFound = blockCombiner.findBlockMatch(charString);
        assertFalse(blockFound.isEmpty());
    }

    @Test
    void shouldDisableBlockUsed(){
        String charString = "UH";
        Optional<Block> blockFound = blockCombiner.findBlockMatch(charString);
        Optional<Block> blockFound2 = blockCombiner.findBlockMatch(charString);
        assertFalse(blockFound.isEmpty());
        assertTrue(blockFound2.isEmpty());
    }

    @Test
    void shouldCreateWordA(){
        assertTrue(blockCombiner.createWord("A"));
    }

    @Test
    void shouldCreateWordBark(){
        assertTrue(blockCombiner.createWord("BARK"));
    }

    @Test
    void shouldNotCreateWordBook(){
        assertFalse(blockCombiner.createWord("BOOK"));
    }
/*
    @Test
    void shouldCreateWordTreat(){
        assertTrue(blockCombiner.createWord("TREAT"));
    }

    @Test
    void shouldNotCreateWordCommon(){
        assertFalse(blockCombiner.createWord("COMMON"));
    }

    @Test
    void shouldCreateWordSquad(){
        assertTrue(blockCombiner.createWord("SQUAD"));
    }

    @Test
    void shouldCreateWordConfuse(){
        assertTrue(blockCombiner.createWord("CONFUSE"));
    }
 */
}
