package DSA.PrintThePatternQuestion;

public class PrintInvertedHalfPyramid {
    public static void printInvertedHalfPyramid() {
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        printInvertedHalfPyramid();
    }
}
