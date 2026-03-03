package Collections.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {
    public static void main(String[] args) {
        /**
         * ArrayList: when there is need of random indexed access
         * internal DS is array.
         * initial capacity of 10, when list reaches capacity: new array of size 1.5 times is re-allocated
         * */
        ArrayList<String> sL = new ArrayList<>(4);

        // create or add

        System.out.println("list size before adding first element: " + sL.size());
        sL.add("Apple");
        sL.add("Apple1");
        System.out.println("list size after adding first element: " + sL.size());
        sL.add("Banana");
        sL.add("Cherry");
        sL.add("Pineapple");
        // read
        System.out.println("first element: " + sL.get(0));
        // update
        sL.set(0, "Mango");
        System.out.println("index of mango: " + sL.indexOf("Mango"));
        // delete
        sL.remove("Cheery");
        System.out.println("cherry index: " + sL.indexOf("Cheery"));
        // ensureCapacity
        sL.ensureCapacity(15);
        System.out.println("size " + sL.size());
        // now we dont need the size 15 whatever is current size that is fine
        sL.trimToSize();
        System.out.println("capacity trimmed to size: " + sL.size());
        // contains
        System.out.println("does it contain apple: " + sL.contains("Apple"));

        // insert at specific index of list
        System.out.println("Original List: " + sL);
        sL.add(2, "Guava");
        System.out.println("After inserting: " + sL);

        ///  iterating
        // index based
        for (int i = 0; i < sL.size(); i++) {
            System.out.println(sL.get(i));
        }
        // for each or enhanced for loop
        System.out.println("with enhanced loop:");
        for (String s : sL) {
            System.out.println(s);
//            sL.remove(s);// ConcurrentModificationException
        }
        System.out.println("after removing all the ele: " + sL);

        //Iterator
        System.out.println("using iterator");
        Iterator<String> it = sL.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // sort
        Collections.sort(sL);
        System.out.println("after sorting: " + sL);
        // sorting in reverse order
        Collections.sort(sL, Collections.reverseOrder());
        System.out.println("reverse order sort: " + sL);
        /**
         * LinkedList: when there is need of insertion and deletion at the end or start of list
         *  doubly linked list is internal data structure
         *  Capacity concept does not apply to LL, since next node will be allocated based on space
         * */

        LinkedList<String> sLL = new LinkedList<>(sL);
        // create
        sLL.add("abc");
        System.out.println("abc is at" + sLL.indexOf("abc"));
        System.out.println("SLL list size after adding first 5 element: " + sLL.size());

        // read
        System.out.println(sLL.get(0));
        sLL.add("Peru");
        sLL.add("Cheeku");
        System.out.println(sLL.getLast());
        System.out.println(sLL.indexOf("Cheeku"));

        // update
        sLL.set(5, "Jamun");
        System.out.println(sLL.getLast());

        // delete
        sLL.remove("Cheeku");
        System.out.println(sLL.indexOf("Cheeku"));
        System.out.println(sLL.indexOf("Jamun"));

        sLL.remove("Jamun");
        System.out.println(sLL.indexOf("Jamun"));

        // Iterating over LL
        System.out.println("items from LL: ");
        for (int i = 0; i < sLL.size(); i++) {
            System.out.println(sLL.get(i));
        }
        // for each or enhanced for loop
        System.out.println("with enhanced loop:");
        for (String s : sLL) {
            System.out.println(s);
        }
        //Iterator
        System.out.println("using iterator");
        Iterator<String> it1 = sLL.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        // sort
        Collections.sort(sLL);
        System.out.println("after sorting: " + sLL);
        // sorting in reverse order
        Collections.sort(sLL, Collections.reverseOrder());
        System.out.println("reverse order sort: " + sLL);

        // Stack : is another implementation of List interface with Stack & Vector as concrete classes
        // legacy: DO NOT USE IN NEW CODE
        List<Integer> iL = new Stack<>();
        List<Integer> iL1 = new Vector<>();

        // replacements for Stack
        Deque<Integer> adqStack = new ArrayDeque<>();
        adqStack.push(100);
        adqStack.push(200);
        adqStack.pop();
        System.out.println("stack : " + adqStack);

        // use synchronized list or arrayList or copyOnWriteArrayList instead of vector
        List<String> vector1 = Collections.synchronizedList(sL); // must be in synchronized block
        List<String> vector2 = new ArrayList<>();
        List<String> vector3 = new CopyOnWriteArrayList<>();

        //| Feature             | ArrayList     | LinkedList        | Vector        |
        // |——————————————————— |———–———————————|———————————————————|——————————————— |
        // Internal Structure   | Dynamic array | Doubly linked list| Dynamic array (legacy) |
        // | Access Time        | O(1)          | O(n)              | O(1) |
        // | Insertion/Deletion | O(n)          | O(1)              | O(n) |
        // | Thread-Safe        | No            | No                | Yes (synchronized) |
        // | Use Case           | Random access | Frequent insertions/deletions | Legacy (avoid) |


        //| Feature | Array             |          ArrayList |
        // |————————|——————-————————————|———————————————————–|
        // | Size | Fixed size | Dynamic size |
        // | Type | Can store primitives and objects | Only stores objects |
        // | Performance | Slightly faster | Slightly slower |
        // | Memory | Fixed memory | Grows as needed |
        // | Methods | Limited methods | Rich API (add, remove, etc.) |
    }
}
