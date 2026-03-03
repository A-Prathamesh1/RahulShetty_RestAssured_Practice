package coding_basics.StringRelated;

public class OccurrenceOfEachCharWithoutHashMap {
    public static void main(String[] args) {
        String s = "communicative";
        int[] iAr = new int[123];
        for (char ch : s.toCharArray()) {
            iAr[ch] += 1;
        }
        System.out.println("character occurrences: ");
        for (int i = 97; i <= 122; i++) {
            if (iAr[i] > 0) {
                System.out.println((char) i + ":" + iAr[i]);
            }
        }
    }
}
