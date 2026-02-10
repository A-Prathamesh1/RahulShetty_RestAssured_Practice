package DSA.PrintThePatternQuestion;

public class PrintPattern1 {
    /*
        Print the following pattern
    *   *****
    *   *****
    *   *****
    *   *****
    * */
    public static void main(String[] args) {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
