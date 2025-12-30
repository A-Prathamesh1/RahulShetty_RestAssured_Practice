package coding_basics;

import java.util.ArrayList;
import java.util.Arrays;

public class FindCommonElementsInArray {
    public static void main(String[] args) {
        int[] ar1 = {1, 2, 3, 4, 5, 6, 7};
        int[] ar2 = {6, 7, 8, 9, 0};
        int indexEle;
        ArrayList<Integer> common = new ArrayList<>();
        for (int i = 0; i < ar1.length; i++) {
            indexEle = ar1[i];
            for (int j = 0; j < ar2.length; j++) {
                if (indexEle == ar2[j]) {
                    common.add(indexEle);
                }
            }
        }
        System.out.println("common: " + common);
    }
}
