package coding_basics.StringRelated;

public class RemoveDigitsFromString {
    public static void main(String[] args) {
        String s = "Welcome234To567Java89Programming0@#!!";
        char[] sAr = s.toCharArray();
        String s1 = "";
        String spsym = "";
        for (int i = 0; i < sAr.length; i++) {
            if (!Character.isDigit(sAr[i])) {
                s1 += sAr[i];
            }
            if (!Character.isAlphabetic(sAr[i]) && !Character.isDigit(sAr[i])) {
                spsym += sAr[i];
            }
        }
        System.out.println("removed digits: " + s1);
        System.out.println("only special syms: " + spsym);
    }
}
