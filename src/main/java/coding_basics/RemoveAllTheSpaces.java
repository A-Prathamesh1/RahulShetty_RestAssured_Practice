package coding_basics;

public class RemoveAllTheSpaces {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        // remove all the spaces from string
        String s = "   this is   statement   also this is  ";
        // s = s.replaceAll("\\s+","");
        char[] chAr = s.toCharArray();
        // System.out.println("stripped:" + s);
        String res = "";
        for (char ch : chAr) {
            if (ch == ' ') {
                continue;
            } else {
                res += ch;
            }
        }
        System.out.print("[" + res + "]");
    }
}
