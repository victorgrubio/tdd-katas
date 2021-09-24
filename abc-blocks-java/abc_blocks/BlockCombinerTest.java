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
        assertEquals(blockCombiner.anyBlockMatch(charString), true);
    }

    @Test
    void shouldWordWithMatchingBlock(){
        String charString = "HU";
        Optional<Block> blockFound = blockCombiner.findBlockMatch(charString);
        assertEquals(blockFound.isEmpty(), false);
    }

    @Test
    void shouldWordWithMatchingBlockInverse(){
        String charString = "UH";
        Optional<Block> blockFound = blockCombiner.findBlockMatch(charString);
        assertEquals(blockFound.isEmpty(), false);
    }
}
