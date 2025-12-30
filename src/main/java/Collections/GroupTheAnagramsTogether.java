package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupTheAnagramsTogether {
    public static boolean areAnagrams(String s1, String s2) {
        char[] s1A = s1.toCharArray();
        char[] s2A = s2.toCharArray();
        // System.out.println(s1A[0] + " " + s2A[0]);
        Arrays.sort(s1A);
        Arrays.sort(s2A);
        // System.out.println(s1A[0] + " " + s2A[0]);
        return Arrays.equals(s1A, s2A);
    }

    public static void main(String[] args) {
        /*
        * ["eat","tea","ate","tab","bat","not"]
            [[eat,tea,ate],[tab,bat],[not]]
        *
        * */
        // store the array as list in
        List<String> itemList = new ArrayList<>(Arrays.asList("eat", "tea", "ate", "tab", "bat", "not"));
        // create output list
        List<List<String>> outList = new ArrayList<>();
        // crate temp list to store in the outList
        List<String> tempList;// new ArrayList<>();
        // pick one element from list
        for (int i = 0; i < itemList.size(); i++) {
            String idxEle = itemList.get(i);
            //and check with every other element from list if they are anagrams
            tempList = new ArrayList<>();
            for (int j = i + 1; j < itemList.size(); j++) {
                // create a temp list
                // if index element & another element from list are anagrams
                if (areAnagrams(idxEle, itemList.get(j))) {
                    // add them to a temp list
                    tempList.add(idxEle);
                }
            }
            // finally after collecting all the elements into tempList , add the tempList into outList
            outList.add(tempList);
        }
        System.out.println("outList: " + outList);
    }
}
