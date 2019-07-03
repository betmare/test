package dictionariesHashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Magazine {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Long> dictionary = Arrays.stream(magazine).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> notes = Arrays.stream(note).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        boolean can=true;
        for (Map.Entry<String, Long> entry: notes.entrySet()) {
            long countD = dictionary.getOrDefault(entry.getKey(),0L);
            if(entry.getValue()>countD) {
                System.out.print("No");
                can=false;
                break;
            }
        }
        if (can) {
            System.out.print("Yes");
        }
    }
    public static void main(String[] args) {
        String[] magazine = ("apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg").split(" ");
        String[] note = ("elo lxkvg bg mwz clm w").split(" ");
        checkMagazine(magazine,note);
    }
}
