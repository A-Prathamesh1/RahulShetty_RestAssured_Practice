package coding_basics.StringRelated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PallindromeOrNot {
    public static boolean isPal(String s) {
        int k = 0;
        boolean isPal = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != s.charAt(k)) {
                isPal = false;
            }
            k++;
        }
        return isPal;
    }
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("mango", "racecar", "madam", "malayalam"));
        for (String s : l) {
            System.out.println(s + " :" + isPal(s));
        }
    }
}
