package DSA.BitManupulation.BitMapEXercise;

import java.util.Arrays;
import java.util.Scanner;

public class CountThe1sInBinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        char[] chAr = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        /*for (int i = 0; i <= chAr.length - 1; i++) {
            if (chAr[i] == '1') {
                count++;
            }
        }*/
        while (n > 0) {
            n &= (n - 1); // removes the rightmost bit of 1 from n
            count++;
        }
        System.out.println("Number of 1's in " + n + " : " + Arrays.toString(chAr) + " are " + count);
    }
}
