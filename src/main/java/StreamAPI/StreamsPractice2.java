package StreamAPI;

import java.util.stream.IntStream;

public class StreamsPractice2 {
    public static void main(String[] args) {
        int upperLimit = 500_000; // Adjust for more/less CPU load

        // Sequential stream: count primes
        long startTime = System.nanoTime();
        long primeCountSeq = IntStream.rangeClosed(2, upperLimit)
                .filter(StreamsPractice2::isPrime)
                .count();
        long endTime = System.nanoTime();
        System.out.println("Sequential stream prime count: " + primeCountSeq +
                ", time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Parallel stream: count primes
        startTime = System.nanoTime();
        long primeCountPar = IntStream.rangeClosed(2, upperLimit)
                .parallel()
                .filter(StreamsPractice2::isPrime)
                .count();
        endTime = System.nanoTime();
        System.out.println("Parallel stream prime count: " + primeCountPar +
                ", time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Checks if a number is prime (CPU-intensive for large numbers)
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
