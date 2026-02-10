package DSA.PrintThePatternQuestion;

/*
 * print the hollow rectangle
 *   *****
 *   *   *
 *   *   *
 *   *****
 *
 * */
public class PrintPatternHollowRectangle {
    public static void printHollowBox1() {
        System.out.println("Printing hollow box1");
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i == 0 || i == 3) {
                    System.out.print("*");
                } else if ((i == 1 || i == 2) && (j == 0 || j == 4)) {
                    System.out.print("*");
                } else if ((i == 1 || i == 2) && (j > 0 && j < 4)) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void printHollowBox2() {
        System.out.println("Printing hollow box2");
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i == 0 || j == 0 || i == 3 || j == 4) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printHollowBox1();
        System.out.println();
        printHollowBox2();
    }
}
