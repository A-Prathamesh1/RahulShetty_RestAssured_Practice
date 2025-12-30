package JavaRegex;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWithExtension {
    public static void main(String[] args) {
        // Get the location
        File f = new File("C:\\Users\\praausek\\Downloads");
        //get the list of files
        String[] listOfFiles = f.list();
        // create pattern for to identify files from list
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_\\-$.]*[.]png");
        // iterate over the list to extract the titles of files of specific extension
        int count = 0;
        for (String t : listOfFiles) {
            Matcher m = p.matcher(t);
            if (m.matches()) {
                count++;
                System.out.println(t);
            }
        }
        System.out.println("Total matches: " + count);
    }
}
