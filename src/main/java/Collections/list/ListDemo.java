package Collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collections;

public class ListDemo {
    public static void main(String[] args) {
        /**
         * ArrayList: when there is need of random indexed access
         * internal DS is array.
         * initial capacity of 10, when list reaches capacity: new array of size 1.5 times is re-allocated
         * */
        ArrayList<String> sL = new ArrayList<>(10);

        // create or add

        System.out.println("list size before adding first element: " + sL.size());
        sL.add("Apple");
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
        ///  iterating
        // index based
        for (int i = 0; i < sL.size(); i++) {
            System.out.println(sL.get(i));
        }
        // for each or enhanced for loop
        System.out.println("with enhanced loop:");
        for (String s : sL) {
            System.out.println(s);
//            sL.remove(s);
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
        sLL.remove("Cheeku");
        System.out.println(sLL.indexOf("Cheeku"));
        System.out.println(sLL.indexOf("Jamun"));
        // delete
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
    }
}
