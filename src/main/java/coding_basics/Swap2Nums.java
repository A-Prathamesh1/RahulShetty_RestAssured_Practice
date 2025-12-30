package coding_basics;

import java.util.Scanner;

public class Swap2Nums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of A:");
        int a = sc.nextInt();
        System.out.println("Enter value of B:");
        int b = sc.nextInt();
        sc.close();
        System.out.println("Before swapping a: " + a + " b:" + b);
        // swap using 3rd variable
        /*int temp = a;
        a = b;
        b = temp;*/
        /*
        int temp = a + b;
        a = temp - a;
        b = temp - b;*/

        // swap without using third variable
        /*a = a + b;
        b = a - b;
        a = a - b;*/

        // swapping using XOR operator
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After swapping a:" + a + " b:" + b);


    }
}
