package DSA.javaStrings;

import java.util.Scanner;

public class CreateUserNameFromEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the email: ");
        String em = sc.next();
        String un = "";
        for (int i = 0; i < em.length(); i++) {
            if (em.charAt(i) == '@') {
                break;
            } else {
                un += em.charAt(i);
            }
        }

        System.out.println("un: " + un);
    }
}
