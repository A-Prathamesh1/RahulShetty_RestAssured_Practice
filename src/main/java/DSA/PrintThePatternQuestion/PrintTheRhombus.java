package DSA.PrintThePatternQuestion;

public class PrintTheRhombus {
    public static void printTheRhombus() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.print("-");
            }
            System.out.print("*****\n");
        }
    }

    public static void main(String[] args) {
        printTheRhombus();
    }
}
