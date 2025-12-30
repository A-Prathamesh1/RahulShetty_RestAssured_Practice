package coding_basics;

import java.util.stream.LongStream;

public class LargestPrimeFactor {
    public static void main(String[] args) {
        // this is wrong logic as it does not consider prime factor to be larger than n
        int n = 42;
        System.out.println("\nNumber: " + n);

        long largestPrimeFactor = findLargestPrimeFactor(n);
        System.out.println("Largest prime factor: " + largestPrimeFactor);
    }

    public static long findLargestPrimeFactor(long n) {
        for (long i = (long) Math.sqrt(n); i >= 2; i--) {
            if (n % i == 0 && isPrime(i)) {
                return i;
            }
        }
        return n;
    }

    public static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(number))
                .allMatch(n -> number % n != 0);
    }
}

