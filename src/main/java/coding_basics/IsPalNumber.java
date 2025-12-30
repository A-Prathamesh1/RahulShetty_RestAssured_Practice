package coding_basics;

public class IsPalNumber {
    public static void main(String[] args) {
        int n = 1234321;
        // reverse the number
        // compare the two numbers

        // lets reverse number
        int temp = 0;
        int rev = 0;
        while (n > 0) {
            temp = n % 10;
            rev = (rev * 10) + temp;
            n = n / 10;
        }
        System.out.println("reverse: " + rev);
        if (rev == n) {
            System.out.println("its pal");
        } else {
            System.out.println("its not");
        }
    }
}
