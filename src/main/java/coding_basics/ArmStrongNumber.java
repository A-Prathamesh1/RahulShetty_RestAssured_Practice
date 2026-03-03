package coding_basics;

public class ArmStrongNumber {
    public static void main(String[] args) {
        int n = 153;
        int n1 = n;
        int temp;
        int sum = 0;
        while (n > 0) {
            temp = n % 10;
            sum += Math.pow(temp, 3);
            n = n / 10;
        }

        if (n1 == sum) {
            System.out.println(n1 + " is a armstrong number");
        } else {
            System.out.println(n1 + " is not a armstrong number");
        }
    }
}
