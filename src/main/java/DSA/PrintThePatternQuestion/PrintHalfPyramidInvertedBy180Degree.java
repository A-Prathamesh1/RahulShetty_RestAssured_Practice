package DSA.PrintThePatternQuestion;

/*
 * print the half pyramid inverted by 180 degrees
 *
 * */
public class PrintHalfPyramidInvertedBy180Degree {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
