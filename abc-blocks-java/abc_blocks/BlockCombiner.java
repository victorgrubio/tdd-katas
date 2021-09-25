package abc_blocks;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class BlockCombiner {

    private List<Block> blockList;

    public BlockCombiner(List<Block> blockList) {

        this.blockList = blockList;
    }

    public int getTotalBlocks() {
        return this.blockList.size();
    }

    public boolean anyBlockMatch(String charString) {
        charString = charString.toUpperCase(Locale.ROOT);
        String finalCharString = charString;
        return blockList.stream().anyMatch(
                block -> block.right().equals(finalCharString) || block.left().equals(finalCharString)
        );
    }

    public Optional<Block> findBlockMatch(String charString) {
        charString = charString.toUpperCase(Locale.ROOT);
        String[] splitString = charString.split("");
        Optional<Block> resultBlock =  blockList.stream().parallel()
                .filter(block -> blockMatchString(splitString, block)).findAny();
        if (resultBlock.isPresent()) blockList.remove(resultBlock.get());
        return resultBlock;
    }

    private boolean blockMatchString(String[] splitString, Block block){
        boolean response = false;
        if (block.left().equals(splitString[0]) && block.right().equals(splitString[1])){
            response = true;
        } else if (block.right().equals(splitString[0]) && block.left().equals(splitString[1])){
            response = true;
        }
        return response;
    }

    public boolean createWord(String charString) {
        boolean response = false;
        return response;
    }
}
