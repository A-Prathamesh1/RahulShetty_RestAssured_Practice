package DSA.PrintThePatternQuestion;

/*
 * print the half pyramid
 *   *
 *   **
 *   ***
 *   ****
 *
 * */
public class PrintPatternHalfPyramid {
    public static void printTheHalfPyramid() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printTheHalfPyramid();
    }
}
