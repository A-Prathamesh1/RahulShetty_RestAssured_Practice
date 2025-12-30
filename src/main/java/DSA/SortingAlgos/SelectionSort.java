package DSA.SortingAlgos;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // selection sort selects the smallest element and brings it to 1st position
        int[] iAr = {7, 8, 3, 2, 1};
        int smallest;
        for (int i = 0; i < iAr.length; i++) {
            smallest = i; // keep the index of smallest instead of element
            for (int j = i + 1; j < iAr.length; j++) {
                if (iAr[j] < iAr[smallest]) {
                    smallest = j;
                }
            }
            // before looking for another smallest
            // swap
            int temp = iAr[smallest];
            iAr[smallest] = iAr[i];
            iAr[i] = temp;
        }
        System.out.println("Sorted: " + Arrays.toString(iAr));
    }
}
