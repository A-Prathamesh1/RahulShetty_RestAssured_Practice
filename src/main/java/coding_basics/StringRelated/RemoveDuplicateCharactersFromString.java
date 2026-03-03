package coding_basics.StringRelated;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharactersFromString {
    public static void main(String[] args) {
        String s = "aabbcc112233";
        Set<Character> seen = new HashSet<>();
        StringBuilder res = new StringBuilder();
        // remove the duplicate chars from the string
        // for every char from string
        for (char ch : s.toCharArray()) {
            // if that character is not in the set
            if (!seen.contains(ch)) {
                // then add the character in the set
                seen.add(ch);
                // append it to string of non duplicates
                res.append(ch);
            }
        }
        // print the string of nonDuplicates
        System.out.println(res);
    }
}
