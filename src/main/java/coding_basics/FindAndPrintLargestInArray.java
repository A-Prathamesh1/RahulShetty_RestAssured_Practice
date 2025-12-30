package coding_basics;

import java.util.Arrays;
import java.util.Collections;

public class FindAndPrintLargestInArray {
    public static void main(String[] args) {
        int[] a = {25, 11, 7, 75, 56};
//        Arrays.sort(a);
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(a[a.length - 1]);
    }
}

