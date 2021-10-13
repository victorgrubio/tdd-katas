package xmas;
import java.util.Collection;
import java.util.List;


public class Printer {

    private XMasSinger xmasSinger;

    public Printer(XMasSinger xmasSinger){
        this.xmasSinger = xmasSinger;
    }

    public void printOneDaySing(int limitDay, List<List<String>> displayed){
        List<String> sungDayLyrics = xmasSinger.singDay(limitDay);
        displayed.add(sungDayLyrics);
        printLyrics(sungDayLyrics);
    }
        
    public void printIterativeSing(int limitDay, List<List<String>> displayed){
        xmasSinger.singAllDayUntilDay(limitDay).stream().forEach(
                sungDayLyrics -> {
                    displayed.add(sungDayLyrics);
                    printLyrics(sungDayLyrics);
                    System.out.println("");
                }
        );
    }

    private void printLyrics(Collection lyrics){
        lyrics.forEach(lyricPart -> {
            if (lyricPart instanceof Collection){
                printLyrics((Collection) lyricPart);
            }
            else{
                System.out.println(lyricPart);
            }
        });
    }

    
}