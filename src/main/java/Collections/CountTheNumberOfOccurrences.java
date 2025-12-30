package Collections;

import java.util.*;

public class CountTheNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        String input = "aabbccdd";
        char[] chAr = input.toCharArray();
        Map<Character, Integer> m = new HashMap<>();

        for (Character ch : chAr) {
            // if the char is not mapped
            if (!m.containsKey(ch)) {
                m.put(ch, 1);
            } else {
                // if char is mapped
                m.put(ch, m.get(ch) + 1);
            }
        }

        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
