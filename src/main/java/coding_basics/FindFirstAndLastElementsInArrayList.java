package coding_basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFirstAndLastElementsInArrayList {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>(Arrays.asList(4, 2, 3, 1, 6));
        System.out.println("Get First: " + al.getFirst());
        System.out.println("Get Last: " + al.getLast());

        System.out.println("First: " + al.get(0));
        System.out.println("Last: " + al.get(al.size() - 1));
    }
}
