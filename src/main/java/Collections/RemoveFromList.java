package Collections;

import java.util.*;

public class RemoveFromList {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("One");
        l.add("two");
        l.add("three");
        // remove the items from list
        try {
            for (String s : l) {
                //l.remove(s);// should not work
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(e.getMessage());
            System.out.println("can not modify the collection while iterating");
        }
        // instead use iterator
        System.out.println("Before removing");
        for (String s : l) {
            System.out.println(s);
        }
        Iterator<String> it = l.iterator();
        while (it.hasNext()) {
            String s = it.next();
            it.remove();
        }
        System.out.println("after removing");
        for (String s : l) {
            System.out.println(s);
        }
    }
}
