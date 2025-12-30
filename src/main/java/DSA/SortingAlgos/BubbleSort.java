package DSA.SortingAlgos;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the size of the array: ");
//        int sz = sc.nextInt();
        int[] iAr = new int[]{7, 3, 8, 1, 2};
        int sz = iAr.length;
//        for (int i = 0; i < sz; i++) {
//            System.out.println("Enter the " + i + "th element: ");
//            iAr[i] = sc.nextInt();
//        }

        System.out.println("Sorting Array using Bubble sort: ");
        int temp;
        // for n -1 passes
        for (int i = 0; i < iAr.length; i++) {
            // for element sorted until current iteration
            for (int j = 0; j < iAr.length - i - 1; j++) {
                if (iAr[j] > iAr[j + 1]) {
                    temp = iAr[j];
                    iAr[j] = iAr[j + 1];
                    iAr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted: " + Arrays.toString(iAr));
    }
}
