package DSA.javaStrings.StringBuilderDemo;

import java.util.Scanner;

public class ReplaceEwithI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with e in it: ");
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == 'e' || sb.charAt(i) == 'E'){
                sb.setCharAt(i,'i');
            }
        }
        System.out.println("after replacing: " + sb);
    }
}
