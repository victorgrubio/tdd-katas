package abc_blocks;

import java.util.List;
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
        return blockList.stream().anyMatch(block -> block.right().equals(charString) || block.left().equals(charString));
    }

    public Optional<Block> findBlockMatch(String charString) {
        String[] splitString = charString.split("");
        return blockList.stream().parallel().filter(block -> blockMatchString(splitString, block)).findAny();
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
}
