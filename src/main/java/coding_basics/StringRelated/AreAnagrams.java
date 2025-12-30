package coding_basics.StringRelated;

import java.util.Arrays;

public class AreAnagrams {
    public static void main(String[] args) {
        /*
         * listen silent
         * */
        String s1 = "listeno";
        String s2 = "silent";
        if (s1.length() != s2.length()) {
            System.out.println("not anagrams");
        }
        char[] s1Ar = s1.toLowerCase().toCharArray();
        char[] s2Ar = s2.toLowerCase().toCharArray();

        Arrays.sort(s1Ar);
        Arrays.sort(s2Ar);

        System.out.println("are anagrams: " + Arrays.equals(s1Ar, s2Ar));
    }
}
