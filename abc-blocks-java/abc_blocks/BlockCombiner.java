package abc_blocks;

import javax.swing.text.html.Option;
import java.util.*;

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
        Optional<Block> foundBlock =  blockList.stream().filter(
                block -> block.right().equals(finalCharString) || block.left().equals(finalCharString)
        ).findAny();
        removeFoundBlock(foundBlock);
        return foundBlock.isPresent();
    }

    private void removeFoundBlock(Optional<Block> foundBlock){
        if (foundBlock.isPresent()) blockList.remove(foundBlock.get());
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

    public boolean createWord(String word) {
        word = word.toUpperCase();
        String[] splitString = splitToNChar(word, 2);
        boolean response = Arrays.stream(splitString).allMatch(
                splitBlockString -> isAvailableBlock(splitBlockString));
        return response;
    }

    private boolean isAvailableBlock(String splitBlockString) {
        boolean response;
        if (splitBlockString.length() == 1){
            response = anyBlockMatch(splitBlockString);
        }
        else {
            response = checkDoubleCharString(splitBlockString);
        }
        return response;
    }

    private boolean checkDoubleCharString(String splitBlockString){
        boolean response = Arrays.stream(
                    splitBlockString.split("")
            ).allMatch(charString -> anyBlockMatch(charString));
        return response;
    }

    private static String[] splitToNChar(String text, int size) {
        List<String> parts = new ArrayList<>();

        int length = text.length();
        for (int i = 0; i < length; i += size) {
            parts.add(text.substring(i, Math.min(length, i + size)));
        }
        return parts.toArray(new String[0]);
    }
}
