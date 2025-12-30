package JavaRegex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneAndEmailExtractor {
    public static void main(String[] args) throws IOException {
        // extract all email & phone numbers from a text file
        Pattern p = Pattern.compile("(0|91)?[789][0-9]{9}");
        Pattern p1 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        //create the output file
        PrintWriter pw = new PrintWriter("C:\\Users\\praausek\\Documents\\Automation Workspace\\Selenium Maven Intellij\\PracticeProject\\src\\main\\java\\JavaRegex\\Output.txt");
        //read the file for to look for number
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\praausek\\Documents\\Automation Workspace\\Selenium Maven Intellij\\PracticeProject\\src\\main\\java\\JavaRegex\\input.txt"));
        String line = br.readLine();
        Matcher m;
        Matcher m1;
        while (line != null) {
            m = p.matcher(line);
            m1 = p1.matcher(line);
            if (m1.find() && m.find()) {
                System.out.println(m.group() + ", " + m1.group());
                pw.println(m.group() + ", " + m1.group());
            }
            if (m.find()) {
                System.out.println(m.group());
                pw.println(m.group());
            }
            line = br.readLine();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}
