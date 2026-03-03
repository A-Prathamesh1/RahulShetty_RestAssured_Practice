package coding_basics;

public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] iAr = {1, 2, 4, 5};
        int n = iAr[iAr.length - 1];

        int sumOfDigitsFrom1ToN = n * (n + 1) / 2;
        int sum = 0;
        for (int i : iAr) {
            sum += i;
        }
        System.out.println("missing number is " + (sumOfDigitsFrom1ToN - sum));
    }
}
