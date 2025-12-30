package coding_basics;

import java.util.ArrayList;
import java.util.List;

public class OddEvenNumbers {
    public static void main(String[] args) {
        /*
         * print odd & even numbers less than 10
         * */
        List<Integer> evenL = new ArrayList<>();
        List<Integer> oddL = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                evenL.add(i);
            } else {
                oddL.add(i);
            }
        }
        System.out.println("Even: " + evenL);
        System.out.println("Odd: " + oddL);
    }
}
