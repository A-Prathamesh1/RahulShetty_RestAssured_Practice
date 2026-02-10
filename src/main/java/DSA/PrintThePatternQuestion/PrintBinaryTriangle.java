package DSA.PrintThePatternQuestion;

/*
 * 1
 * 0 1
 * 1 0 1
 * 0 1 0 1
 * 1 0 1 0 1
 * */
public class PrintBinaryTriangle {
    public static void printBinaryTriangle() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                }
                if ((i + j) % 2 != 0) {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printBinaryTriangle();
    }
}
