package Collections.comparator.Revision;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<TestCase> tL = new ArrayList<>();
        tL.add(new TestCase("test1", 2));
        tL.add(new TestCase("test2", 5));
        tL.add(new TestCase("test3", 3));

        System.out.println("Before sorting: " + tL);
        /*
         * Comparator: Multiple sorting strategies (external, flexible)
         *
         * */
        Comparator<TestCase> nameComparator = (tc1, tc2) -> tc1.name.compareTo(tc2.name);
        Collections.sort(tL, nameComparator);

        System.out.println("After sorting by name: " + tL);

        Comparator<TestCase> prioComparator = (tc1, tc2) -> tc1.priority - tc2.priority;
        Collections.sort(tL, prioComparator);

        System.out.println("after sorting by priority: " + tL);


        Comparator<TestCase> byPrioDesc = (t1, t2) -> t2.priority - t1.priority;
        tL.sort(byPrioDesc);
        System.out.println("byPrioDesc: " + tL);
    }
}
