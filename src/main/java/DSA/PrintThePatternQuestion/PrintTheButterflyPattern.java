package DSA.PrintThePatternQuestion;

/*
 *   *             *
 *   * *         * *
 *   * * *     * * *
 *   * * * * * * * *
 *   * * * * * * * *
 *   * * *     * * *
 *   * *         * *
 *   *             *
 *
 * */

public class PrintTheButterflyPattern {
    public static void main(String[] args) {
        for (int i = 0; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int k = 1; k <= 2 * (4 - i); k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        for (int j = 4; j >= 1; j--) {
            for (int k = 1; k <= j; k++) {
                System.out.print("*");
            }
            for (int k = 1; k <= 2 * (4 - j); k++) {
                System.out.print(" ");
            }
            for (int l = 1; l <= j; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
