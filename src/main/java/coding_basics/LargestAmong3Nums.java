package coding_basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.max;

public class LargestAmong3Nums {
    public static void main(String[] args) {
        int num1 = 127, num2 = 19, num3 = 10;

        if (num1 > num2 && num1 > num3) {
            System.out.println(num1 + " is largest");
        } else if (num2 > num1 && num2 > num3) {
            System.out.println(num2 + " is largest");
        } else if (num3 > num1 && num3 > num2) {
            System.out.println(num3 + " is largest");
        }
//        int n = ;//Collections.max(new ArrayList<>(Arrays.asList(num1, num2, num3)));

//        System.out.println("max : " + n);
    }
}
