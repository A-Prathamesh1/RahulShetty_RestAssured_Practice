package Collections.FailFastAndFailSafeIterators;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafeDemo {
    public static void main(String[] args) {
        List<Integer> iL = new ArrayList(Arrays.asList(1, 3, 4, 5, 6));
        // fail fast iterator

        /*for (Integer i : iL) {
            if (i == 3) {
                iL.remove(3);
            }
        }*/

        // fail safe iterator
        Iterator<Integer> intIterator = iL.iterator();
        while (intIterator.hasNext()) {
            Integer i = intIterator.next();
            if (i == 3) {
              //  iL.remove(i); // still throws ConcurrentModificationException
//                intIterator.remove(); // correct way to remove, however still fail fast
            }
        }
        System.out.println("after removing 3: " + iL);

        // Fail fast iterator : ArrayList, HashSet, HashMap
        // Fail safe iterators: ConcurrentHashMap, CopyOnWriteArrayList

        List<Integer> failSafeList = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4));

        Iterator<Integer> failSafeIterator = failSafeList.iterator();
        while (failSafeIterator.hasNext()) {
            Integer i = failSafeIterator.next();
            if (i == 3) {
                failSafeList.remove(i); // removing from fail safe iterator i.e CopyOnWriteArrayList does not throw the ConcurrentModificationException
            }
        }
        System.out.println("after removing 3 from list: " + failSafeList);
    }
}
