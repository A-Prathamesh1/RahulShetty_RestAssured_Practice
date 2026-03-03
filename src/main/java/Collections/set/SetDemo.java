package Collections.set;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

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


//     | Feature     | HashSet             | TreeSet      |   LinkedHashSet |
//     |—————————————|—————————————————————|——————————————|——————————————-——|
//     | Order       | No guaranteed order | Sorted order | Insertion order |
//     | Performance | O(1) average        | O(log n)     | O(1) average    |
//     | Thread-Safe | No                  |     No       |     No          |
//     | Null Values | Allows              | Does not allow |   Allows      |
//     | Comparable  | No                  | Yes (elements must b comparable) | No |


// | Feature              | HashSet                     | LinkedHashSet                      | TreeSet                          |
// |——————————————————————|———————————————|——————————————————————————|——————————————————————————|
// | Internal Structure    | Hash table (HashMap)        | Hash table + Doubly linked list    | Red-Black Tree (Balanced BST)    |
// | Ordering              | No order                    | Insertion order maintained         | Sorted (natural/comparator order)|
// | Null Allowed          | Yes (only one null)         | Yes (only one null)                | No (throws NullPointerException) |
// | Access Time           | O(1) average                | O(1) average                       | O(log n)                         |
// | Insertion/Deletion    | O(1) average                | O(1) average                       | O(log n)                         |
// | Thread-Safe           | No                          | No                                 | No                               |
// | Duplicate Allowed     | No                          | No                                 | No                               |
// | Use Case              | Fast lookup, no order       | Maintain insertion order           | Sorted unique elements           |


        // Collections.synchronizedSet() allows synchronized options
        Set<Integer> syncHashSet = Collections.synchronizedSet(new HashSet<>());

        Set<Integer> syncLinkedHashSet = Collections.synchronizedSet(new LinkedHashSet<>());

        Set<Integer> syncTreeSet = Collections.synchronizedSet(new TreeSet<>());

        // for high concurrency hashset
        Set<Integer> concurrentSet = ConcurrentHashMap.newKeySet();

        // for high concurrency treeSet
        Set<Integer> concurrentSortedSet = new ConcurrentSkipListSet<>();

        // no option available for linkedHashSet but Collections.synchronizedSet(new LinkedHashSet<>());

    }
}
