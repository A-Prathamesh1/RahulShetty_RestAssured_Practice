package Collections;

import java.util.*;

public class GroupAnagrams {
    public static String sort(String str) {
        char[] chAr = str.toCharArray();
        Arrays.sort(chAr);
        return new String(chAr);
    }

    public static void main(String[] args) {
        ArrayList<String> itemList = new ArrayList<>(Arrays.asList("eat", "tea", "ate", "tab", "bat", "not"));

        // create key value map of keys from itemList mapped to list of strings
        Map<String, List<String>> mapOfAna = new HashMap<>();

        // for every word in the item list
        for (String word : itemList) {
            // sort the word as key
            String key = sort(word);
            // get the list mapped to the key
            List<String> groupOfAna = mapOfAna.get(key);
            // check if the list exists
            // if list does not exists
            if (groupOfAna == null) {
                // create an empty list and assign it to group of angram list
                groupOfAna = new ArrayList<>();
                // and map the key to the list in map of anagrams
                mapOfAna.put(key, groupOfAna);
            }
            // else (if list exists) put the word in the list
            groupOfAna.add(word);
        }
        List<List<String>> outList = new ArrayList<>(mapOfAna.values());
        System.out.println(outList);
    }
}
