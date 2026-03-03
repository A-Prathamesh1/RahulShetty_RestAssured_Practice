package coding_basics;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int fact = 1;
//        for (int i = 1; i <= n; i++) {
//            fact *= i;
//        }
        while (n > 0) {
            fact = fact * n;
            n--;
        }
        System.out.println(fact);

        System.out.println("factorial of 5: " + facto(1));
    }

    // recursive factorial
    public static int facto(int n) {
        if (n == 1 || n == 0) { // base condition
            return 1;
        }
        return n *= facto(n - 1); // recursive call
    }
}
