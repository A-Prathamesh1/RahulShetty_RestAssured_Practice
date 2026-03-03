package coding_basics.StringRelated;

public class ReverseAString {
    public static void main(String[] args) {
        String s = "pineapple";
        String rev = "";
//        for (int i = s.length() - 1; i >= 0; i--) {
//            rev += s.charAt(i);
//        }
        StringBuffer sbf = new StringBuffer(s);
        System.out.println(sbf.reverse());

        StringBuilder sb = new StringBuilder(sbf);
        System.out.println(sb.reverse());

        String s1 = sb.toString();
        System.out.println(s1);

        System.out.println("reverse of apple: " + recReverse("apple"));
    }

    public static String recReverse(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return recReverse(s.substring(1)) + s.charAt(0);
    }
}
