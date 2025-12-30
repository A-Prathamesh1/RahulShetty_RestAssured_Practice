package coding_basics.StringRelated;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicateCharactersFromString {
    public static void main(String[] args) {
        char[] chAr = "this is string!".toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        for (Character ch : chAr) {
            if (!m.containsKey(ch)) {
                m.put(ch, 1);
            } else {
                m.put(ch, m.get(ch) + 1);
            }
        }

        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println(e.getKey() + " appears " + e.getValue() + " times");
            }
        }
    }
}
