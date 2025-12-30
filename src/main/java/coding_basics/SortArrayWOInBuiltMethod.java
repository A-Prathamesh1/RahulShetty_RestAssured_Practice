package coding_basics;

import java.util.Arrays;

public class SortArrayWOInBuiltMethod {
    public static void main(String[] args) {
        int[] ar = {10, 5, 20, 63, 12, 57, 88, 60};
        int temp;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[i] > ar[j]) {
                    //swap
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        System.out.println("sorted: " + Arrays.toString(ar));
    }
}
