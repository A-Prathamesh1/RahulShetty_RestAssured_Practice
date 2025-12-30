package coding_basics.StringRelated;

import java.util.HashMap;
import java.util.Map;

public class Counting_number_of_occurrences_of_given_word_in_a_string {
    public static void main(String[] args) {
        String s = "Java is a software programming language. Java is widely used in software Testing";
        // split the string into array
        String[] sAr = s.split(" ");
        Map<String, Integer> m = new HashMap<>();
        for (String s1 : sAr) {
            if (!m.containsKey(s1)) {
                m.put(s1, 1);
            } else {
                m.put(s1, m.get(s1) + 1);
            }
        }
        System.out.println("Occurrence of Java: " + m.get("Testing"));
    }
}
