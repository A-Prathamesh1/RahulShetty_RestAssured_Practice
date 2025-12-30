package coding_basics.StringRelated;

public class ReverseEntireSentence {
    public static void main(String[] args) {
        String s = "India is country My";
        String rev = "";
        String[] sAr = s.split(" ");
        for (int i = sAr.length - 1; i >= 0; i--) {
            rev += sAr[i] + " ";
        }
        System.out.println("reversed: " + rev);
    }
}
