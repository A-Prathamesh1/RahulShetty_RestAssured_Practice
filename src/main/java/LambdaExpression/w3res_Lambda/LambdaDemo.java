package LambdaExpression.w3res_Lambda;

import LambdaExpression.Student;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.*;
import java.util.stream.IntStream;


public class LambdaDemo {

    public static void main(String[] args) {
//    SoftAssert softAssert = new SoftAssert();

        //1. Sum two integers using lambda expression
//        BiFunction<Integer, Integer, Integer> a1 = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> a1 = Integer::sum;
        System.out.println(a1.apply(10, 120));

        // 2. Check if a string is empty using lambda
//        Predicate<String> e = (s) -> s.isEmpty();
        Predicate<String> e = String::isEmpty;
        System.out.println("is string empty: " + e.test(""));

        // 3. Convert strings to upper/lowercase using lambda
//        Function<String, String> toUp = s -> s.toUpperCase();
        Function<String, String> toUp = String::toUpperCase;
//        Function<String, String> toLow = s -> s.toLowerCase();
        Function<String, String> toLow = String::toLowerCase;
        System.out.println(toUp.apply("mango"));
        System.out.println(toLow.apply("pineapple"));

        // OR
        List<String> sL = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "PINK"));
        System.out.println("Original List " + sL);
        //  to uppercase
//        sL.replaceAll(s -> s.toUpperCase());
        sL.replaceAll(String::toUpperCase);
        System.out.println("to uppercase list: " + sL);

        //to lowercase list
//        sL.replaceAll(s -> s.toLowerCase());
        sL.replaceAll(String::toLowerCase);
        System.out.println("To LowerCase" + sL);
        // 4. Filter even and odd numbers with lambda

        // Filter even & odd numbers using lambda
        List<Integer> nL = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);
        Predicate<Integer> evenOddP = n -> n % 2 == 0;
        List<Integer> eL = new ArrayList<>();
        List<Integer> oL = new ArrayList<>();

        List<Integer> eL1 = nL.stream()
                .filter(n1 -> n1 % 2 == 0)
                .toList();
        List<Integer> ol1 = nL.stream()
                .filter(n1 -> n1 % 2 != 0)
                .toList();
        System.out.println("eL: " + eL1 + "\noL: " + ol1);

        //sorting string alphabetically
        List<String> col = Arrays.asList("red", "green", "blue", "black", "pink");
        col.sort(String::compareTo);
        System.out.println("after sort: " + col);

        //Write a Java program to implement a lambda expression to find the average of a list of doubles.
        List<Double> dL = Arrays.asList(3.5, 7.5, 4.3, 4.7, 5.1);
        double avg = dL.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        System.out.println("avg: " + avg);

        // Remove integer duplicates using lambda
        List<Integer> iL = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 6);
        List<Integer> nonDuplicteList = new ArrayList<>();
        iL.stream().distinct().forEach(nonDuplicteList::add);
        System.out.println(nonDuplicteList);

        // calculate factorials using lambda expression
        // lambda does not need to be 1 liner
        Function<Integer, Integer> f = n -> {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
                System.out.println(fact);
            }
            return fact;
        };
        System.out.println(f.apply(5));

        // prime number using lambda
        Predicate<Integer> isPrime = n -> {
            boolean primeHaiKya = true;
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    System.out.println("divisible by: " + i);
                    primeHaiKya = false;
                }
            }
            return primeHaiKya;
        };
        System.out.println("" + isPrime.test(51));

        // concatenate 2 strings using lambda
        BiFunction<String, String, String> concat = String::concat;
        System.out.println(concat.apply("this is ", "India"));

        // find min & max ins the list of elements using lambda.
        List<Integer> il1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println("min: " + il1.stream().min(Integer::compareTo).get());
        System.out.println("max: " + il1.stream().max(Integer::compareTo).get());

        // Multiply and sum list elements using lambda
        List<Integer> il2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int sum = il2.stream().reduce(Integer::sum).get();
        System.out.println("sum: " + sum);
        int prod = il2.stream().reduce(1, (n, n1) -> n * n1);
        System.out.println("prod: " + prod);

        // Count the words in sentence using lambda
        String s = "This is India, don't let it catch you sleeping";
        String[] sAr = s.split("\\s");
        int count = Arrays.stream(sAr).toList().size();
        System.out.println("count: " + count);

        // split the string > count the words
        Function<String, Integer> f1 = s1 -> (s1.split("\\s")).length;
        System.out.println("length of the string: " + f1.apply(s));

        // check if string is palindrome
        String s2 = "amalayalama";
        Predicate<String> revIt = str -> {
            String s3 = new StringBuilder(str).reverse().toString();
            return s3.equals(str);
        };
        System.out.println("isPal: " + revIt.test(s2));


        //Sum squares of odd/even numbers using lambda
        List<Integer> iL1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // map to squares > reduce to sum
        int sumOfE = iL1.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * n).sum();
        System.out.println("sumfoE: " + sumOfE);
        //softAssert.assertEquals(sumOfE, 120, "sum of evens do not match");

        int sumOfO = iL1.stream().filter(n -> n % 2 != 0).mapToInt(n -> n * n).sum();
        System.out.println("sumfoO: " + sumOfO);
        //softAssert.assertEquals(sumOfO, 84, "sum of odds do not match");
        //softAssert.assertAll();
        System.out.println("This will execute");


        List<String> sL1 = Arrays.asList("this", "is", "India");
        Predicate<String> p = s1 -> s1.equals("India");
        boolean res = sL1.stream().anyMatch(p);
        Assert.assertTrue(res, "list does not contain the word \"India\"");
        System.out.println("Sum all primes in range using lambda".replace(" ", "_"));


        List<String> sL2 = Arrays.asList("This", "is", "India");
        Function<List<String>, Integer> sf = s21 -> {
            String sm = s21.getFirst();
            for (int i = 1; i < s21.size(); i++) {
                if (s21.get(i).length() < sm.length()) {
                    sm = s21.get(i);
                }
            }
            System.out.println("sm: " + sm);
            return sm.length();
        };
        System.out.println("sm: " + sf.apply(sL));
        Function<List<String>, Integer> lf = s22 -> {
            String lm = s22.getFirst();
            for (int i = 1; i < s22.size(); i++) {
                if (s22.get(i).length() > lm.length()) {
                    lm = s22.get(i);
                }
            }
            System.out.println("lm: " + lm);
            return lm.length();
        };
        System.out.println("lf: " + lf.apply(sL));

        // using streams
        System.out.println("longest: " + sL.stream().mapToInt(String::length).max().orElse(0));
        System.out.println("smallest: " + sL.stream().mapToInt(String::length).min().orElse(0));


        Predicate<Integer> p1 = n -> ((int) Math.sqrt(n) * (int) Math.sqrt(n)) == n;
        //Assert.assertTrue(p1.test(101), "number is not perfect square");


        List<Integer> iL2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // finding the largest
        int secondLargest = iL2.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("second largest: " + secondLargest);

        int secondSmallest = iL2.stream().distinct().sorted().skip(1).findFirst().orElse(-1);
        System.out.println("second smallest: " + secondSmallest);


        List<Student> sL3 = Arrays.asList(new Student(1, "Prathamesh"), new Student(5, "Nityashree"), new Student(3, "Avyaan"));
        Comparator<Student> c = (Student o1, Student o2) -> Integer.compare(o1.roll, o2.roll);
        List<Student> ssL = sL3.stream().sorted(c).toList();
        System.out.println("Sorted students: ");
        ssL.forEach(s3 -> System.out.println(s3.roll + ": " + s3.name));

        // sum of primes within range
        int l = 1;
        int h = 10;
        System.out.println("Sum of primes:  " + sum);

        int sumOfPrimes = IntStream.rangeClosed(l, h).filter(LambdaDemo::isPrime).sum();
        System.out.println("prime sum from 1 to 10: " + sumOfPrimes);

        // Check case of strings in list using lambda
        List<String> sL4 = Arrays.asList("JAVA", "PYTHON", "ABC");
        List<String> sL5 = Arrays.asList("java", "python", "abc");
        List<String> mL = Arrays.asList("java", "python", "abc", "RUBY", "C");
        // Determine if the string is uppercase or lower case using lambda
        Predicate<String> p2 = s3 -> s3.toUpperCase().equals(s3);
//        System.out.println("is uppercase: " + p2.test(sL4.get(0)));
        boolean areAllUpperCase = mL.stream().allMatch(p2);
        System.out.println("are all uppercase: " + areAllUpperCase);

        Predicate<String> isLowerCase = s5 -> s5.toLowerCase().equals(s5);
        boolean areAllLowerCase = mL.stream().allMatch(isLowerCase);
        System.out.println("are all lowerCase: " + areAllLowerCase);
        // if all are NOT uppercase & all are NOT Lowercase then they must be mixed case
        boolean isMixedCase = !areAllLowerCase && !areAllUpperCase;
        System.out.println("are mixedcase: " + isMixedCase);

        //Find average string length using lambda
        List<String> lis = Arrays.asList("this ", "is ", "India ");
        System.out.println("avg length of string: " + lis.stream().map(String::length).reduce(Integer::sum).get() / lis.size());

        //Find largest prime factor using lambda

        // integer to binary using lambda expression
        int n = 10;
        Function<Integer, String> decToBin = Integer::toBinaryString;
        System.out.println(n + " in binary: " + decToBin.apply(n));
    }


    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
