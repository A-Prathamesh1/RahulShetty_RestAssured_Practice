package StreamAPI.w3ResourcesStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class JavaStreamDemo {
    public static void main(String[] args) {
        int[] intAr = {4, 5, 6, 8, 7, 2, 4, 2, 4, 5};
        // calculate average using streams
        double d = Arrays.stream(intAr).average().orElse(0);
        System.out.println("Average: " + d);

        // convert strings to lower & uppercase
        String[] colors = {"RED", "grEEn", "white", "Orange", "pink", "Apple", "Banana"};
        System.out.println("uppercase: " + Arrays.stream(colors).map(String::toUpperCase).toList());

        // sum of even & odd numbers in the list
        // filter
        // reduce
        System.out.println("sum of even no: " + Arrays.stream(intAr).filter(n -> n % 2 == 0).sum());
        System.out.println("sum of odd no: " + Arrays.stream(intAr).filter(n -> n % 2 != 0).sum());

        // remove duplicates from stream
        System.out.println("distinct: " + Arrays.toString(Arrays.stream(intAr).distinct().toArray()));

        long noOfStringsStartingWIthW = Arrays.stream(colors).map(s -> s.startsWith("w")).count();
        System.out.println("starting with w: " + noOfStringsStartingWIthW);

        // sort the string with A -Z
        System.out.println("sorted: " + Arrays.stream(colors).sorted().toList());

        System.out.println("reverse sorted: " + Arrays.stream(colors).sorted(Comparator.reverseOrder()).toList());

        // find the min & max
        System.out.println("array: " + Arrays.toString(intAr));
        System.out.println("min of array: " + Arrays.stream(intAr).min().getAsInt());
        System.out.println("max of array: " + Arrays.stream(intAr).max().getAsInt());

        // find the second smallest
        System.out.println(Arrays.toString(intAr));
        System.out.println("second smallest: " + Arrays.stream(intAr).distinct().sorted().skip(1).findFirst().getAsInt());
    }
}
