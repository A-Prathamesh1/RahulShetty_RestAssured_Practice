package Collections.comparable.Revision;

/*
 * TestCase class must have the way to sort or order the instances natural order of sorting or comparing
 * implements Comparable<TestCase>*/
public class TestCase implements Comparable<TestCase> {
    String name;
    int priority;

    public TestCase(String name, int prio) {
        this.name = name;
        this.priority = prio;
    }

    public String toString() {
        return this.name + ":" + this.priority;
    }


    public int compareTo(TestCase tc) {
        System.out.println("compareTo called");
        // descending order
        return tc.priority - this.priority;

        /* ascending
         * return this.priority - tc.priority;
         * */

    }
}
