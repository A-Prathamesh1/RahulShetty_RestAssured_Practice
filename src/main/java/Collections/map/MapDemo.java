package Collections.map;

import java.util.*;
import java.util.concurrent.*;

public class MapDemo {
    public static void main(String[] args) {
        /***
         * HashMap : simplest, allows 1 null key, multiple null values
         *
         * */

        Map<Integer, String> m = new HashMap<>();
        // Create or put
        m.put(1, "Prathamesh");
        m.put(2, "Nityashree");
        m.put(3, "Avyaan");
        m.put(4, "xyz");
        // read
        System.out.println("reading with key: " + m.get(1));

        // Update
        System.out.println("update with key" + m.put(1, "Pratham"));
        System.out.println("getting with key: " + m.get(1));
        System.out.println("updating with update " + m.replace(1, "Prat"));
        System.out.println(m.get(1));

        // delete
        System.out.println("removing 4th : " + m.remove(4));

        // check the presence of key
        System.out.println("does map has the key 1? " + m.containsKey(1));

        // check the presence of value
        System.out.println("does map has value? " + m.containsValue("Prat"));

        // iterate over map using key
        System.out.println("Iterating over the keySet");
        for (Integer i : m.keySet()) {
            System.out.println(i);
        }

        // Iterating over Values
        System.out.println("values: ");
        for (String v : m.values()) {
            System.out.println(v);
//            m.put(5, "avc"); // will cause the ConcurrentModificationException
        }
        ConcurrentHashMap<Integer, String> cm = new ConcurrentHashMap<>(m);

        System.out.println("Iterating over: ");
        Iterator<Map.Entry<Integer, String>> cmIt = cm.entrySet().iterator();
        int count = m.size() - 1;
        while (cmIt.hasNext()) {
            System.out.println(cmIt.next());
            cm.put(count++, "nnn");// did not throw the ConcurrentModificationException,
        }
        System.out.println("After modifying the internal while iterating: " + cm);
        // iterating using key value pair
        System.out.println("Iterating over hashSet using iterator: ");
        for (Map.Entry<Integer, String> e : m.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());

        }
        // Iterating using iterator
        System.out.println("Iterating using iterator on Map.Entry set: ");
        Iterator<Map.Entry<Integer, String>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> e = it.next();
            System.out.println(e.getKey() + " : " + e.getValue());
//            e.setValue("test");
        }
        System.out.println("after setting values in iterator: " + m);
        // sorting a map using a treemap
        m.put(0, "ijk");
        Map<Integer, String> sortedM = new TreeMap<>(m);
        System.out.println("sorted hash map: ");
        System.out.println(sortedM);


        /**
         * LinkedHashMap: maintains insertion order
         *              allows just 1 null, key
         * */
        Map<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(null, "abc");
        lhm.put(null, "pqr");
        lhm.put(null, "ijk");
        lhm.put(1, "abc");
        lhm.put(2, "pqr");
        System.out.println("lhm after inserting multiple null keys");
        System.out.println(lhm);

        System.out.println("iterating over map");
        for (Map.Entry<Integer, String> e : lhm.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        /***
         *  TreeMap: maintains the natural order of keys
         *  does not allow null keys, allows null values
         * */
        Map<Integer, String> tm = new TreeMap<>();
        tm.put(10, "abc");
        tm.put(9, "pqr");
        tm.put(7, "ert");
        tm.put(2, "def");
        tm.put(3, null);
        System.out.println("tree map: " + tm);
        Iterator<Map.Entry<Integer, String>> mit = tm.entrySet().iterator();
        System.out.println("iterating over tree map: ");
        while (mit.hasNext()) {
            Map.Entry<Integer, String> e = mit.next();
            System.out.println(e.getKey() + " : " + e.getValue());
            e.setValue("test");
        }
        System.out.println("after setting value: " + tm);

        // put vs putIfAbsent

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "abc");
        System.out.println("original hm " + hm);
        hm.put(1, "pqr");
        System.out.println("updating the hm " + hm);
        String s = hm.putIfAbsent(1, "xyz");
        System.out.println(s);
        String s1 = hm.putIfAbsent(2, "eee");
        System.out.println(s1);
        System.out.println("getting 2 : " + hm.get(2));
    }
}
