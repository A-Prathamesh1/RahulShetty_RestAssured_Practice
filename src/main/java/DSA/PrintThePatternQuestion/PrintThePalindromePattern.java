package DSA.PrintThePatternQuestion;

/*
 *         1
 *       2 1 2
 *     3 2 1 2 3
 *   4 3 2 1 2 3 4
 * 5 4 3 2 1 2 3 4 5
 * */

public class PrintThePalindromePattern {
    public static void printThePalindromicPattern() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }
            for (int l = 2; l <= i; l++) {
                System.out.print(l);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printThePalindromicPattern();
    }
}
