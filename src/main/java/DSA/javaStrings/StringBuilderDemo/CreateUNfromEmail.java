package DSA.javaStrings.StringBuilderDemo;

import java.util.Scanner;

public class CreateUNfromEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the email: ");
        String em = sc.next();
        StringBuilder sb = new StringBuilder(em);
        System.out.println(sb.substring(0, sb.indexOf("@")));

    }
}
