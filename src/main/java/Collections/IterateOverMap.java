package Collections;

import java.util.*;

public class IterateOverMap {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        m.put("apple", 1);
        m.put("mango", 2);
        m.put("banana", 3);
        // Print the collection
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }


    }
}
