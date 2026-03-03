package StreamAPI.Practice;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamDemo {
    public static void main(String[] args) {

        // steam() vs parallel Stream
        // processed sequentially
        List<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> evenL = al.stream().filter(n -> n % 2 == 0).map(n -> n * 2).toList();
        System.out.println("w stream : " + evenL);

        // processed in parallel
        List<Integer> evenL1 = al.parallelStream().filter(n -> n % 2 == 0).map(n -> n * 2).toList();
        System.out.println("w parallel stream : " + evenL1);

        // sequence is not maintained in parallel as multiple threads work on stream with no sync on order
        List<String> sL = new ArrayList<>(Arrays.asList("Test1", "Test2", "Test3", "Test4", "Test5"));
        System.out.println("streams maintained sequence: ");
        sL.stream().forEach(System.out::print);
        System.out.println();
        System.out.println("parallel stream not in sequence: ");
        sL.parallelStream().forEach(System.out::print);
        System.out.println();
        // compare performance
        List<Integer> iL1 = IntStream.rangeClosed(0, 10000000).boxed().toList();

        long start = System.nanoTime();
        long count = iL1.stream().filter(n -> n % 2 == 0).count();
        System.out.println("w stream: " + (System.nanoTime() - start) + "ns");

        start = System.nanoTime();
        count = iL1.parallelStream().filter(n -> n % 2 == 0).count();
        System.out.println("w ll stream: " + (System.nanoTime() - start) + "ns");

        // filter
        ArrayList<Integer> aL = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> evenL2 = aL.stream().filter(i -> i % 2 == 0).toList();
        // map
        List<Integer> doubledaL = aL.stream().map(i -> i * 2).toList();
        // flatMap
        System.out.println("faltenning list");
        List<List<Integer>> nesaL = Arrays.asList(Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6));
        nesaL.stream().flatMap(List::stream).forEach(System.out::print);
        // reduce
        // collect
    }
}
