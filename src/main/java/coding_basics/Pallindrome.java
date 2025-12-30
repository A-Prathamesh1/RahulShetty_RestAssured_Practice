package coding_basics;

public class Pallindrome {
    public static void main(String[] args) {
        /*
         * find out if a String is palindrome or not
         * e.g.malayalam
         * */
//        int n = 123421;
//        while (n > 0) {
//
//            n = n / 10;
//        }
        String n1 = "malayalam";
        System.out.println(n1.length());
        int j = n1.length() - 1;
        boolean res = false;
        for (int i = 0; i < n1.length() / 2; i++) {
            if (n1.charAt(i) != n1.charAt(j)) {
                res = false;
            } else {
                res = true;
            }
            j--;
        }
        System.out.println("isPal: " + res);
    }
}
