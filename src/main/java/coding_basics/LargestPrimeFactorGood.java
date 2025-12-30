package coding_basics;

import java.util.Scanner;

public class LargestPrimeFactorGood {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to find largest prime factor: ");
        int n = sc.nextInt();
        int ans = 0;
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                ans = Math.max(ans, i);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n > 1) {
            ans = n;
        }
        System.out.println("Largest prime factor: " + ans);
    }
}
