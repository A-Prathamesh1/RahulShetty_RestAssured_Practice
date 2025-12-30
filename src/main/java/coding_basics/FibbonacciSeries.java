package coding_basics;

public class FibbonacciSeries {
    public static void main(String[] args) {
        /*
         * 0, 1, 1, 2,3,5,8,13
         * */
        int n = 1;
        int a = 0;
        int b = 1;
        int c = 0;
        System.out.print(a + ", " + b + ", ");
        while (n <= 10) {
            c = a + b;
            System.out.print(c + ", ");
            a = b;
            b = c;
            n++;
        }

    }
}
