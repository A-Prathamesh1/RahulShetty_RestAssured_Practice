package DSA.BitManupulation.BitMapEXercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IspowOf2 {
    public static void isPow2Method(int n) {
        char[] chAr = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (char ch : chAr) {
            if (ch == '1') {
                count++;
                if (count > 1) {
                    break;
                }
            }
        }
        if (count == 1) {
            System.out.println(n + " is power of 2");
        } else {
            System.out.println("Its not power of 2");
        }
    }

    public static void isPow2Method2(int n) {
        if (n > 0 && (n & (n - 1)) == 0) {
            System.out.println(n + " is power of 2");
        } else {
            System.out.println(n + " is not power of 2");
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i <= 100; i++) {
//            System.out.println(2 + " pow " + i + " : " + (int) Math.pow(2, i) + " : " + Integer.toBinaryString((int) Math.pow(2, i)));
//        }
//        System.out.println(Integer.toBinaryString((int) Math.pow(2, )));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        isPow2Method2(n);
    }
}
