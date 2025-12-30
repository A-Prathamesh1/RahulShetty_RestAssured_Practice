package DSA.ArraysDemo;

import java.util.Arrays;


public class ArrayDemo {
    public static void main(String[] args) {
        int[] iAr = new int[8];
//        Arrays[] ia = new Arrays[3];

        for (int i = 0; i < 8; i++) {
            iAr[i] = (int) (Math.random() * 100);
            System.out.println(iAr[i]);
        }

        // sorting
        Arrays.sort(iAr);
        System.out.println("Sorting into array: " + Arrays.toString(iAr));
        // filling
        int[] i2Ar = new int[8];
        Arrays.fill(i2Ar, 4);
        System.out.println("After filling " + Arrays.toString(i2Ar));
        // searching
        System.out.println("index of 4 in the arr: " + Arrays.binarySearch(iAr, (int) (Math.random() * 10)) + " : " + Arrays.toString(iAr));
        // comparing .equals
        System.out.println("Comparing " + Arrays.toString(iAr) + " & " + Arrays.toString(i2Ar) + " : " + Arrays.equals(iAr, i2Ar));
        // converting to string or to list
        // convert to string
        System.out.println(Arrays.toString(iAr));
        // converting to list
        System.out.println("as list: " + Arrays.asList(2, 3, 4, 5, 13, 61, 73, 81));
        // comparing two-dimensional arrays
        int[][] i3Ar = new int[4][4];
        int[][] i4Ar = new int[4][4];
        int element;
        System.out.println("length of i3Ar: " + i3Ar.length);
        for (int i = 0; i < i3Ar.length; i++) {
            for (int j = 0; j < i3Ar.length; j++) {
                element = (int) (Math.random() * 100);
                i3Ar[i][j] = element;
                i4Ar[i][j] = element;
            }
        }
        System.out.println("i3Ar: " + Arrays.deepToString(i3Ar));
        System.out.println("Are arrays equal: " + Arrays.deepEquals(i3Ar, i4Ar));
        // Arrays.sort(i3Ar); can not sort 2D array
        System.out.println("sort: " + Arrays.deepToString(i3Ar));
    }
}
