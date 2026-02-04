package ArraysDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {

        // search
        int index = Arrays.binarySearch(new int[]{1, 2, 3, 4}, 3);
        System.out.println("index of 3 in " + index);

        // String representation of Array
        System.out.println("String representation of array: " + Arrays.toString(new int[]{1, 2, 3, 4}));

        // Fill the array with specific element
        Integer[] iAr = new Integer[4];
        Arrays.fill(iAr, null);
        System.out.println("iAr: " + Arrays.toString(iAr));

        // Are 2 arrays equal
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 2, 3};
        if (Arrays.equals(a, b)) {
            System.out.println("they are equal");
        } else {
            System.out.println("they are not");
        }

        // sort the elements of array
        int[] iAr1 = new int[]{9, 8, 7, 6, 5, 4};
        Arrays.sort(iAr1);
        System.out.println(Arrays.toString(iAr1));

        // Arrays as list
        ArrayList<Integer> il = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("ArrayList: " + il);

        // compare two arrays
        System.out.println("Are 2 arrays equal: " + Arrays.compare(a, b));

        // partial copy some length of original array to another
        int[] c = Arrays.copyOf(a, 2);
        System.out.println(Arrays.toString(c) + " is copy of " + Arrays.toString(a));

        // copy last 3 elements of array a
        int[] d = Arrays.copyOfRange(a, 1, 2);
        System.out.println(Arrays.toString(a) + "< a,  arrays d is: " + Arrays.toString(d)); // excluding last index

        // set all the elements of array as a function of its index
        int[] a1 = new int[5];
        Arrays.setAll(a1, (i) -> i * 10);
        System.out.println("a1 : " + Arrays.toString(a1));

        // hashCode
        System.out.println("Hash Code of the a1: " + Arrays.hashCode(a1) + " : " + (Arrays.hashCode(a1)));

        // finds & returns the index of first mismatched element
        System.out.println(Arrays.toString(a) + "a<, " + Arrays.toString(a1) + "< a1 ," + "Mismatched index: " + Arrays.mismatch(a1, a));

        // Parallel sort
        int[] a2 = new int[]{9, 8, 7, 6, 5, 4, 3};
        Arrays.parallelSort(a2);
        System.out.println("Parallel Sort: " + Arrays.toString(a2));

        // parallelSetAll: parallelly  set all the elements as a function of its index
        int[] a3 = new int[4];
        Arrays.parallelSetAll(a3, (i) -> i * 2);
        System.out.println("a3: " + Arrays.toString(a3));

//        Arrays.parallelPrefix();


    }
}
