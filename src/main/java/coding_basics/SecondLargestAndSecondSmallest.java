package coding_basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargestAndSecondSmallest {
    public static void main(String[] args) {
        int[] ar = {10, 5, 20, 63, 12, 57, 88, 60};
        Arrays.sort(ar);
//        List<Integer> il = new ArrayList<>(Arrays.asList(10, 5, 20, 63, 12, 57, 88, 60));
//        Collections.sort();
        System.out.println("Second largest: " + ar[ar.length - 1]);
        System.out.println("Second smallest: " + ar[1]);
    }
}
