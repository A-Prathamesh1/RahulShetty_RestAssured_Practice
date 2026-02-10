package coding_basics;

import java.util.Arrays;

public class SmallestElement {
    public static void main(String[] args) {
        int[] iAr = {5, 3, 4, 2, 0, 1, -1};
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i <= iAr.length - 1; i++) {
            if (iAr[i] < smallest) {
                smallest = iAr[i];
            }
        }
        System.out.println("smallest of " + Arrays.toString(iAr) + " is : " + smallest);
    }
}
