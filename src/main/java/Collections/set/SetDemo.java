package Collections.set;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        // All set implementations allows unique elements only
        /**
         * HashSet: Not ordered
         *          fastest
         *          allows 1 Null
         *          internal DS hashtable
         * */
        // create
        Set<String> names = new HashSet<>(3, 0.50f);
        names.add("Nityashree");
        names.add("Pranjal");
        names.add("Amit");
        System.out.println("does resizing happens automatically? :" + names.size());
        names.add("Prathamesh");
        names.add("Avyaan");
        System.out.println("after filling more than 50% capacity: " + names.size());

        System.out.println("No order preserved or each time new results ");
        System.out.println("names set: " + names);

        // iterating
        System.out.println("Iterating over hashset: ");
        for (String name : names) {
            System.out.println(name);
        }

        // iterator
        System.out.println("iterating using iterator");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // sorting by converting to treeSet
        System.out.println("sorted using treeSet");
        System.out.println(new TreeSet<>(names));

        // sort
        System.out.println("sorting hashSet with collection class: ");
        Collections.sort(new ArrayList<>(names));
        System.out.println(names);

        /**
         * LinkedHashSet: Insertion order
         *          slower than HashSet faster than TreeSet
         *          allows 1 NUll
         *          internal DS HashTables + LinkedList
         *
         * */
        Set<Integer> intSet = new LinkedHashSet<>();
        intSet.add(2);
        intSet.add(1);
        intSet.add(3);
        intSet.add(5);
        System.out.println("preserves insertion order");
        System.out.println("intSet : " + intSet);

        // iterating
        System.out.println("Iterating over hashset: ");
        for (Integer in : intSet) {
            System.out.println(in);
        }

        // iterating using iterator
        System.out.println("iterating using iterator");
        Iterator<Integer> intIt = intSet.iterator();
        while (intIt.hasNext()) {
            System.out.println(intIt.next());
        }

        // sort
        System.out.println("sort by converting to tree set: ");
        Set<Integer> ts = new TreeSet<>(intSet);
        System.out.println(ts);

        // sort the set
        System.out.println("sort set using collections: ");
        ArrayList<Integer> inL = new ArrayList<>(intSet);
        Collections.sort(inL);
        System.out.println(inL);

        /**
         * TreeSet: Sorted order custom or natural maintained
         *          slowest
         *          does not allow null
         *          internal Data s. red-black trees
         * */
        Set<Integer> iSet = new TreeSet<>();
        iSet.add(4);
        iSet.add(3);
        iSet.add(2);
        iSet.add(1);
        iSet.add(5);
        System.out.println("maintains sorted order");
        System.out.println("tree set : " + iSet);

        // iterating
        System.out.println("Iterating over hashset: ");
        for (Integer i : iSet) {
            System.out.println(i);
        }

        // iterating using iterator
        System.out.println("iterating using iterator");
        Iterator<Integer> intIt1 = iSet.iterator();
        while (intIt1.hasNext()) {
            System.out.println(intIt1.next());
        }

        // does set contain 3
        System.out.println("does set contain 3: " + iSet.contains(3));

    }
}
