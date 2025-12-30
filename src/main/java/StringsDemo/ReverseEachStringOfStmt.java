package StringsDemo;

public class ReverseEachStringOfStmt {
    public static String capitalizeTheFirstLetter(String s) {
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        return s;
    }

    public static void main(String[] args) {
        String s = "This is a simple statement";
        StringBuilder sbr;
        String[] sAr = s.split("\\s");
        for (int i = 0; i < sAr.length; i++) {
            sbr = new StringBuilder(sAr[i]);
            if (i == 0) {
                sAr[i] = capitalizeTheFirstLetter(sbr.reverse().toString().toLowerCase());
                System.out.print(sAr[i]);
                continue;
            }
            System.out.print(" " + sbr.reverse());
        }
    }
}
