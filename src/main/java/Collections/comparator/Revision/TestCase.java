package Collections.comparator.Revision;

import java.util.Comparator;

/*
 * TestCase class must have different ways to sort test cases by name, by prio, so
 * */
public class TestCase {
    String name;
    int priority;

    public TestCase(String name, int prio) {
        this.name = name;
        this.priority = prio;
    }

    public String toString() {
        return this.name + ":" + this.priority;
    }
    /*public String toString() {
        return this.name + ":" + this.priority;
    }

    public int compareTo(TestCase tc) {
        System.out.println("compareTo called");
        // descending order
        return tc.priority - this.priority;

        *//* ascending
     * return this.priority - tc.priority;
     * *//*
    }*/
}
