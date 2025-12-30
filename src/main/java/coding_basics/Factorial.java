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
    }
}
