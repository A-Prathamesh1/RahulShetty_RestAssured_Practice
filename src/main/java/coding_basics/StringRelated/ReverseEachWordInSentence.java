package coding_basics.StringRelated;

public class ReverseEachWordInSentence {
    public static String reversed(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }

    public static void main(String[] args) {
        String s = "reverse each word in a string";
        String[] sAr = s.split(" ");
        String rev = "";
        for (String s1 : sAr) {
            // reverse each word
            rev += reversed(s1) + " ";
        }
        System.out.println("reversed: " + rev);
    }
}
