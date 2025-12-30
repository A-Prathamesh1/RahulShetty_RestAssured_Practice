package coding_basics;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 38712;
        int sum = 0;
        int temp = 0;
        while (n > 0) {
            temp = n % 10;
            sum += temp;
            n = n / 10;
        }
        System.out.println((3 + 8 + 7 + 1 + 2) == sum);
    }
}
