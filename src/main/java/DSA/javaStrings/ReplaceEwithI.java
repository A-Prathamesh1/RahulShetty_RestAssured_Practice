package DSA.javaStrings;

import java.util.Scanner;

public class ReplaceEwithI {
    public static void main(String[] args) {
        // input the string from user that contains e
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string with e in it: ");
        String s = sc.next();
        String result = "";// s.replace('e', 'i');
        char[] chAr = s.toCharArray();
        for (int i = 0; i < chAr.length; i++) {
            if (chAr[i] == 'e' || chAr[i] == 'E') {
                chAr[i] = 'i';
                result += chAr[i];
            } else {
                result += chAr[i];
            }
        }
        System.out.println("result: " + result);
    }
}
