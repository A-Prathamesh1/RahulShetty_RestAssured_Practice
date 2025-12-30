package DSA.javaStrings;

import java.util.Scanner;

public class CumulativeLengthOfStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Strings you want to enter");
        int sz = sc.nextInt();
        String[] sAr = new String[sz];
        int length = 0;
        for (int i = 0; i < sz; i++) {
            System.out.print("Enter the string: ");
            sAr[i] = sc.next();
            length += sAr[i].length();
            System.out.println();
        }
        System.out.println("Cumulative length: " + length);
    }
}
