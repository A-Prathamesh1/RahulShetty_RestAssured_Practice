package coding_basics.StringRelated;

import java.util.HashMap;
import java.util.Map;

public class CountTheOccurrenceOfEachChar {
    public static void main(String[] args) {
        String s = "This is an example";
        char[] chAr = s.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        for (Character ch : chAr) {
            if (!m.containsKey(ch)) {
                m.put(ch, 1);
            } else {
                m.put(ch, m.get(ch) + 1);
            }
        }
        System.out.println("char occurrence map: " + m);
    }
}
