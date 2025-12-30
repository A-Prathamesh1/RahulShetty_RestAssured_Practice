package coding_basics.StringRelated;

import java.util.*;

public class RemovingDuplicatesFromStringArray {
    public static void main(String[] args) {
        String[] strArray = {"abc", "def", "abc", "mno", "xyz", "pqr", "xyz", "pqr"};
        List<String> al = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            for (int j = i + 1; j < strArray.length; j++) {
                if (strArray[i] == strArray[j]) {
                    System.out.println("Duplicates are: " + strArray[i]);
                }
            }
        }
        //Set<String> s = new HashSet<>(List.of(strArray));

        //System.out.println("non duplicates: " + Arrays.toString(strArray));
    }
}
