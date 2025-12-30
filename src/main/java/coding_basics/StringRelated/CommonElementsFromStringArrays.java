package coding_basics.StringRelated;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommonElementsFromStringArrays {
    public static void main(String[] args) {
        String[] array3 = {"Java", "JavaScript", "C", "C++"};
        String[] array4 = {"Python", "C#", "Java", "C++"};
        String indexEle = "";
        ArrayList<String> sL = new ArrayList<>();
        for (int i = 0; i < array3.length; i++) {
            indexEle = array3[i];
            for (int j = 0; j < array4.length; j++) {
                if (indexEle.equals(array4[j])) {
                    sL.add(indexEle);
                }
            }
        }
        System.out.println("Common: " + sL);

    }
}
