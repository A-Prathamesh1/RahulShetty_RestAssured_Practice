package JavaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateMobileNumber {
    static {
        System.out.println("Enter phone no: ");
    }

    public static void main(String[] args) {
        // compile the pattern
        Pattern p = Pattern.compile("(0|91)?[789][0-9]{9}");
        Matcher m = p.matcher(args[0]);
        if (m.matches()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
