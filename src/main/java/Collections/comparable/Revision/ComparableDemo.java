package Collections.comparable.Revision;

import java.util.ArrayList;
import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {
        List<TestCase> tL = new ArrayList<>();
        tL.add(new TestCase("LoginPage", 3));
        tL.add(new TestCase("HomePage", 4));
        tL.add(new TestCase("SomePage", 2));
        System.out.println("Before sorting: " + tL);
        // we need to sort the tL
        Collections.sort(tL);
        System.out.println("After sorting: " + tL);
    }
}
