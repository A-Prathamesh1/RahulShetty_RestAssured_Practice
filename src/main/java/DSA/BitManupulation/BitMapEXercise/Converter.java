package DSA.BitManupulation.BitMapEXercise;

import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        // decimal to binary
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        String bStr = new String();
        int num;
        while (n != 0) {
            num = n % 2;
            bStr += num;
            n = n / 2;
        }
        StringBuilder str = new StringBuilder(bStr);
        str = str.reverse();
        System.out.println("Binary representation of " + n + " is " + str);

        // binary to decimal
        String s = new String(str);
        char[] chAr = s.toCharArray();
        int decNum = 0;
        int pow = 0;
        for (int i = chAr.length - 1; i >= 0; i--) {
            if (chAr[i] == '1') {
                decNum += 1 * Math.pow(2, pow);
            } else {
                decNum += 0 * Math.pow(2, pow);
            }
            pow++;
        }
        System.out.println("Decimal format number: " + decNum);
    }
}
