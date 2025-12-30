package StreamAPI;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 6, 8, 7, 2, 4);
        System.out.println("Original: " + nums);
        // filter even numbers
        // double them
        // add them
        Predicate<Integer> p1 = new Predicate<Integer>() {
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };

        Function<Integer, Integer> f1 = new Function<Integer, Integer>() {
            public Integer apply(Integer n) {
                return n * 2;
            }
        };

        BinaryOperator<Integer> bo = new BinaryOperator<>() {
            public Integer apply(Integer n, Integer n1) {
                return n1 + n;
            }
        };

        Predicate<Integer> p = n -> n % 2 == 0;
        Function<Integer, Integer> f = n -> n * 2;
        BinaryOperator<Integer> b = (a, c) -> a + c;
        int sumOfDoubledEvenNums = nums.stream()
                .filter(p1)
                .map(f1)
                .reduce(0, bo);

        System.out.println("stream sum: " + sumOfDoubledEvenNums);

        // print the stream using forEach
        // for each take consumer

        Consumer<Integer> con = new Consumer<Integer>() {
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        // with stream
        Stream<Integer> s = nums.stream();
        System.out.println("Printing using for each: ");
        //s.forEach(con);

        // what does map, filter ,reduce accept as argument, which functional interface ?
        nums.stream().map(f); // map takes function
        nums.stream().filter(p); // filter takes predicate
        nums.stream().reduce(bo); // binary operator

        // utilities using streams
        List<Integer> listOfInt = s.toList();
        System.out.println("printing the list of integers: " + listOfInt);

        // counting the elements in the stream
        Stream<Integer> s1 = nums.stream();
        System.out.println("there are " + s1.count() + " elements in the stream");

        // distinct elements from the list
        Stream<Integer> s2 = nums.stream();
        System.out.println("There are " + s2.distinct().toList() + " distinct elements in the stream");

        // to array
        Stream<Integer> s3 = nums.stream();
        Object[] a = s3.toArray();
        System.out.println("contents of stream: " + Arrays.toString(a));

        // min max
        Stream<Integer> s4 = nums.stream();
        java.util.Optional o = s4.min((n1, n2) -> n1.compareTo(n2));
        System.out.println("minimum: " + o.get());

        Stream<Integer> s5 = nums.stream();
        int max = s5.max((n1, n2) -> n1.compareTo(n2)).get();
        System.out.println("max ele: " + max);

        // sorting using streams
        Stream<Integer> s6 = nums.stream();
        System.out.println("sorted " + s6.sorted().toList());

        // find first
        Stream<Integer> s7 = nums.stream();
        System.out.println("first element from stream: " + s7.findFirst().get());

        // iterator
        Stream<Integer> s8 = nums.stream();
        Iterator<Integer> it = s8.iterator();
        System.out.println("Elements from stream: ");
        while (it.hasNext()) {
            System.out.print(", " + it.next());
        }


        // stream instance can be used only once: so following won't execute since s has been used already
        // Stream<Integer> s1 = s.filter(n -> n % 2 == 0);

        //Stream<Integer> s2 = s1.map(n -> n * 2);
        //int sumOfDoubledEvens = s2.reduce(0, (a, c) -> a + c);
        //s2.forEach(integer -> System.out.println(integer));
        //System.out.println("Sum of doubled evens: " + sumOfDoubledEvens);
//        Consumer<Integer> con = integer -> {
//            System.out.println(integer);
//        };
//        nums.forEach(integer -> {
//            System.out.println(integer);
//        });
        //nums.forEach(n -> System.out.println(n));

//
//        int sum = 0;
//        for (int n : nums) {
//            if (n % 2 == 0) {
//                n *= 2;
//                sum += n;
//                System.out.println(n);
//            }
//        }
//        System.out.println("sum: " + sum);
    }
}
