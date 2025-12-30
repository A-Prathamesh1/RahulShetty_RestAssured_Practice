package DSA.BitManupulation.BitMapEXercise;

import java.util.Arrays;
import java.util.Scanner;

public class ToggleTheBitAtPos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to who's bit you want to toggle: ");
        int n = sc.nextInt();
        String binN = Integer.toBinaryString(n);
        System.out.println(n + " in binary " + binN);
        System.out.println("Enter the position of bit to be toggled(position starts with 0): ");
        int pos = sc.nextInt();

        int bitMask = 1 << pos;
        // updating the bit it either setting it or clearing it
        // what is the bit, is it 1 or 0
        char[] chAr = binN.toCharArray();
        int bit = 0;
        for (int i = chAr.length - 1; i >= 0; i--) {
            if (pos == i) {
                bit = chAr[pos];
            }
        }
        System.out.println("The bit you want to flip is: " + bit + " of " + Arrays.toString(chAr));
        if (bit == 48) {
            System.out.println("Setting the bit at " + pos + " : " + (n | bitMask) + " : " + Integer.toBinaryString(n | bitMask));
        } else {
            System.out.println("Clearing the bit at " + pos + " : " + (n & (~bitMask)) + " : " + Integer.toBinaryString(n & (~bitMask)));
        }
    }
}
