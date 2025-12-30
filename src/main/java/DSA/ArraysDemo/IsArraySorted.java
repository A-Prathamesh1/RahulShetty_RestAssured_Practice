package DSA.ArraysDemo;

import java.util.Arrays;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] iAr = new int[10];
        for (int i = 0; i < iAr.length; i++) {
            iAr[i] = (int) (Math.random() * 100);
            System.out.print(iAr[i] + ", ");
        }
//        Arrays.sort(iAr);
        System.out.println(" : length: " + iAr.length);
        // for every element in the array,
        // compare the current element with its next element
        // if the current element is greater than the next, the set the boolean flag to false
        boolean isSorted = true;
        for (int i = 0; i < iAr.length - 1; i++) {
            if (iAr[i] > iAr[i + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println("is " + Arrays.toString(iAr) + " sorted: " + isSorted);
    }
}
