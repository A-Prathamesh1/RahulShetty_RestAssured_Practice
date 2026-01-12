package StreamAPI.JavaMadeSoEasy;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
https://www.javamadesoeasy.com/2017/06/convert-arraylist-in-streams-in-java-8.html
* */
public class StreamsPractice {
    public static void main(String[] args) {
        // in one line display all records that start with 'a' in stringList
        List<String> sL = Arrays.asList("abc", "apple", "back", "pull", "done", "cat", "apk", "ada");
        sL.stream().filter(s -> s.startsWith("a")).toList().forEach(System.out::println);

        // // In one line display all records (in sorted manner - ASCENDING) that start with 'a' in stringList
        System.out.println("start with 'a':  ");
        sL.stream().filter(s -> s.startsWith("a")).sorted().toList().forEach(System.out::println);

        // starting with a, in descending order
        System.out.println("start with 'a' reversed:  ");
        sL.stream().filter(s -> s.startsWith("a")).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // all uppercase strings starting with a in sorted manner
        System.out.println("all uppercase strings starting with a in sorted manner");
        sL.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted().toList().forEach(System.out::println);

        // find if ant record stats with 'a'
        System.out.println("starts with a: ");
        System.out.println("does any start with a: " + sL.stream().anyMatch(s -> s.startsWith("a")));

        // does all start with A
        System.out.println("does all start with a: " + sL.stream().allMatch(s -> s.startsWith("a")));

        // find if none records starts with b
        System.out.println("does none of them starts with B: " + sL.stream().noneMatch(s -> s.startsWith("b")));

        // count the records that starts with a
        System.out.println("no of records starting with a: " + sL.stream().filter(s -> s.startsWith("a")).count());

        //Convert ArrayList of Integers to Streams in java 8
        List<Integer> iL = new ArrayList<>();
        iL.add(1);
        iL.add(2);
        iL.add(3);
        iL.add(4);

        Stream<Integer> intStream = iL.stream();
        System.out.println("Stream of integers: ");
        intStream.forEach(System.out::println);

        // Convert ArrayList of String to Streams in java 8
        List<String> strL = new ArrayList<>();
        strL.add("apple");
        strL.add("mango");
        strL.add("pineapple");

        Stream<String> strStream = strL.stream();
        System.out.println("String stream: l");
        strStream.forEach(System.out::println);

        // Create Stream of Integer in java 8
        Stream<Integer> is = Stream.of(1, 2, 3, 4);
        System.out.println("Stream of integers: ");
        is.forEach(System.out::println);
        Stream<Integer> ist = Stream.of(new Integer[]{1, 2, 3, 4});

        // create stream of strings
        // of is static method of streams hence type.nameofMethod
        Stream<String> ss = Stream.of("Abc", "pqr", "jki");

        // parallel stream vs sequential stream
        long startTime = 0;
        long endTime = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i <= 9992999; i++) {
            l.add(i);
        }
        System.out.println("Parallel stream: ");
        startTime = System.nanoTime();
        long count = l.parallelStream().count();
        endTime = System.nanoTime();
        long par = endTime - startTime;
        System.out.println(count + "total time for parallel " + (endTime - startTime));

        startTime = System.nanoTime();
        count = l.stream().count();
        endTime = System.nanoTime();
        long seq = endTime - startTime;
        System.out.println(count + "total time for seq: " + (endTime - startTime));

        //Reduce list to store it in Optional in java 8
        List<String> aL = new ArrayList<>();
        aL.add("a");
        aL.add("b");
        aL.add("c");
        aL.add("d");

        Optional<String> o = aL.stream().reduce((a, b) -> a + ", " + b);
        System.out.println("check if value is present: " + o.isPresent());

        o.ifPresent(s -> System.out.println("get the value: " + s));

        // short-circuiting operations
        // finding distinct elements
        List<String> sLi = new ArrayList<>();
        sLi.add("a");
        sLi.add("b");
        sLi.add("c");
        System.out.println("Distinct elements from list: ");
        sLi.stream().distinct().forEach(System.out::println);

        // find first
        Optional<String> firstOp = sLi.stream().findFirst();
        System.out.println("Getting first element: ");
        firstOp.ifPresent(System.out::println);

        //return any element from list
        Optional<String> ostr = sLi.stream().findAny();
        System.out.println("optional anny element: ");
        ostr.ifPresent(System.out::println);

        // any record start with a
        Optional<String> o1 = sLi.stream().filter(s -> s.startsWith("a")).findAny();
        System.out.println("find any that starts with a: ");
        o1.ifPresent(System.out::println);

        // none of the records starts with b
        boolean b = sLi.stream().noneMatch(s -> s.startsWith("b"));
        System.out.println("Does any record starts with B: " + b);

        // count the strings starting with a
        long a = sLi.stream().filter(s -> s.startsWith("a")).count();
        System.out.println("how many starts with a: " + a);

        // Infinite Sequential ordered and unordered Stream - in java 8

        // generate infinite sequential unordered stream
        Supplier<Integer> s = () -> (int) (Math.random() * 10);
        Stream<Integer> infUnorderedSequence = Stream.generate(s);
        System.out.println("Generating 10 random numbers: ");
        infUnorderedSequence.limit(10).forEach(System.out::println);

        // infinite sequential ordered
        Stream<Integer> infiniteOrderedSequence = Stream.iterate(1, i -> i + 1);
        System.out.println("infinite ordered sequence: ");
        infiniteOrderedSequence.limit(10).forEach(System.out::println);

        // write to generate 10 random characters
        Stream<Character> charS = Stream.generate(() -> (char) ((int) (Math.random() * 26) + 65));
        System.out.println("10 random characters: ");
        charS.limit(10).forEach(System.out::println);

        // Create STREAM, filter, display and sorting
        System.out.println("stream of int filtered sorted displayed : ");
        IntStream.range(0, 10).filter(n -> n % 2 == 0).sorted().forEach(System.out::println);

        System.out.println("stream of random ints sorted filtered displayed: ");
        Stream.generate(() -> (int) (Math.random() * 10)).limit(10).sorted().filter(i -> i % 2 == 0).forEach(System.out::println);

        // crate double stream & reduce double stream in java
        DoubleStream doubleStream = DoubleStream.of(0.1, 0.2, 0.3);
        double i = doubleStream.reduce(0, (a1, b1) -> a1 + b1);
        System.out.println("double sum : " + i);

        // crate a int stream & reduce it
        IntStream iSte = IntStream.of(0, 1, 2, 3, 4);
        System.out.println("stream of integers reduced: " + iSte.reduce(0, (a2, b2) -> a2 + b2));

        // how to use optionalInt
        OptionalInt oi = OptionalInt.of(5);
        //isPresent
        System.out.println("is there a value? " + oi.isPresent());
        //orElse
        System.out.println("is there a value orElse get: " + oi.orElse(4));
        //get
        System.out.println("value is : " + oi.getAsInt());
        //ifPresent
        System.out.println("if there is value get it: ");
        oi.ifPresent(System.out::println);

        // OptionalDouble
        OptionalDouble od = OptionalDouble.of(1.2);
        System.out.println("get the value: " + od.getAsDouble());

        // find all the even number between 1 to 5
        IntStream ints = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("all the evens between 1 to 5");
        ints.filter(n -> n % 2 == 0).forEach(System.out::println);

        // finding all the numbers between 1 to 5, that are greater than 2
        IntStream is1 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("all number sgreater than 2: ");
        is1.filter(n -> n > 2).forEach(System.out::println);

        // finding all the numbers that are greater than 2 & are even
        IntStream in2 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("finding all the numbers that are greater than 2 & are even");
        in2.filter(n -> n % 2 == 0).filter(n -> n > 2).forEach(System.out::println);

        // sum all the nums between 1 to 5
        IntStream in3 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("sum from 1 o 5: " + in3.reduce(0, (n1, n2) -> n1 + n2));

        // maximum of 1 to 5
        IntStream in4 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("max of 1 to 5: " + in4.max().getAsInt());

        // Minimum of 1 to 5
        IntStream in5 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("minimum of 1 to 5: " + in5.min().getAsInt());

        // count the number in stream
        IntStream in6 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("count the numbers between 1 to 5: " + in6.count());

        // average of stream
        IntStream in7 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("average : " + in7.average().getAsDouble());

        // findFirst
        IntStream in8 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("first: " + in8.findFirst().getAsInt());
        // findAny
        IntStream in9 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("any no out of stream: " + in9.findAny().getAsInt());
        // anyMatch()
        IntStream in10 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("is there any match greater than 2: " + in10.anyMatch(n -> n > 2));
        // allMatch()
        IntStream in11 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("are all elements greater than 0: " + in11.allMatch(n -> n > 0));
        // noneMatch()
        IntStream in12 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("does none are > 0: " + in12.noneMatch(n -> n > 0));

        // find sum between 1 to 5 and add 10 to sum
        IntStream in13 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("sum should be 25: " + in13.reduce(10, (n1, n2) -> n1 + n2));

        //


    }
}
