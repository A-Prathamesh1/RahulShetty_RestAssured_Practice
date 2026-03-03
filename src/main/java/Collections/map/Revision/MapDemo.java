package Collections.map.Revision;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();

        m.put("a", 1);
        m.put("b", 2);
        m.put("c", 3);
        m.put("d", 4);

        // iterating over keySet()
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }

        // iterating over values
        for (Integer v : m.values()) {
            System.out.println(v);
        }

        // iterating over keys
        for (String k : m.keySet()) {
            System.out.println(k);
        }
        //using streams over entrySet()
        m.entrySet().stream().forEach(e -> System.out.print(e.getKey() + ":" + e.getValue() + "\n"));

        //using just lambda
        m.entrySet().forEach(e -> System.out.print(e.getKey() + ":" + e.getValue() + "\n"));

        // change the value of key c = 500
        m.entrySet().stream().filter(e -> e.getKey().equals("c")).forEach(e -> e.setValue(500));

        System.out.println("after setting: " + m);
    }
}
