package DSA.javaStrings.StringBuilderDemo;

import java.util.Scanner;

public class CumulativeLengthOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Strings: ");
        int sz = sc.nextInt();
        String[] aAr = new String[sz];
        System.out.println("Enter the string: ");
        int cumuLength = 0;
        for (int i = 0; i < sz; i++) {
            System.out.println("Enter String: ");
            aAr[i] = sc.next();
            cumuLength += aAr[i].length();
        }
        System.out.println("cumulative length: " + cumuLength);
    }
}
