package Collections;

import java.util.*;

public class Collections_Demo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("apple");
        c.add("pineapple");

        List<String> l = new ArrayList<>();
        l.add("appple");
        l.add("pineapple");

        ArrayList<String> al = new ArrayList<>();
        al.add("apple");
        al.add("pineapple");

        ArrayList<Integer> il = new ArrayList<>(Arrays.asList(7, 6, 1, 2, 3, 4, 5));
        Collections.sort(il);

        System.out.println("sorted list: " + il);
        System.out.println("list size: " + il.size());
        System.out.println("list is empty: " + il.isEmpty());
        System.out.println(Arrays.toString(il.toArray()));
        System.out.println("does it contains 5: " + il.contains(5));
        System.out.println("String: " + il);

        Collections.reverse(il);
        System.out.println("after reversing: " + il);
        SortedMap<Character, Integer> m = new TreeMap<>();
//        NavigableMap<Character, Integer> nm = new TreeMap<>();
//        SequencedMap<Character, Integer> sm = new EnumMap<>();
//        LinkedHashMap

//        Iterator;
//        Iterable;
//        ListIterator;
//        Comparable;
//        Comparator;
        // Collections is a utility class that has static method to help
        List<Integer> c2 = new ArrayList();
        c2.add(1);
        c2.add(2);
        c2.add(4);

        // static methods of Collections utility class

        Collections.reverse(c2);
        System.out.println("reversed: " + c2);

        Collections.sort(c2);
        System.out.println("after sorting: " + c2);

        Collections.addAll(c2, 4, 5);
        System.out.println("after adding: " + c2);

        int max = Collections.max(c2);
        int min = Collections.min(c2);
        System.out.println("min: " + min + " max: " + max);

        Collections.shuffle(c2);
        System.out.println("After shuffling: " + c2);

        // option for legacy vector class from List interface of Collection
        Collections.synchronizedList(c2);
    }
}
