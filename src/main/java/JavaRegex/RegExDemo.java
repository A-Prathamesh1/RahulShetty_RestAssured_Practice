package JavaRegex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {
    public static void main(String[] args) {
        String stringToCompare = "ababbaba";
        Pattern p = Pattern.compile("ba");
        System.out.println("p: " + p);
        Matcher m = p.matcher(stringToCompare);
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println(" count: " + count + " start: " + m.start() + ": end : " + m.end() + ": group:" + m.group());
        }
//        System.out.println("count: " + count);

        System.out.println("does ba matches wholes string ababbaba:" + m.matches());

        // Character Classes
        /*
         * [abc] - a or b or c
         * [^abc] except a or b or c
         * [a-z] any lowercase letter
         * [A-Z] any uppercase character
         * [a-zA-Z] any alphabet symbol
         * [0-9] any digit from 0 to 9
         * [a-zA-Z0-9] any alphanumeric character
         * [^a-zA-Z0-9] except alphanumeric characters
         * []
         * */

        Pattern p1 = Pattern.compile("x");
        Matcher m1 = p1.matcher("a7b@2#9");

        // looking for x
        while (m1.find()) {
            System.out.println("start: " + m1.start() + " end: " + m1.end() + ": " + m1.group());
        }

        //looking for [abc]
        String s2 = "a7b@z#9";
        Pattern p2 = Pattern.compile("[abc]");
        Matcher m2 = p2.matcher(s2);
        System.out.println("p: " + p2 + " in " + s2);
        while (m2.find()) {
            System.out.println("start: " + m2.start() + " end: " + m2.end() + " group: " + m2.group());
        }

        // looking for neither abc [^abc]
        Pattern p3 = Pattern.compile("[^a-zA-Z0-9]");
        Matcher m3 = p3.matcher(s2);
        System.out.println("not P: " + p3 + " in: " + s2);
        while (m3.find()) {
            System.out.println("s: " + m3.start() + " e: " + m3.end() + ", group: " + m3.group());
        }

        // pre-defined character classes
        /*
         * \s - space character
         * \S - except space character
         * \d - any digit
         * \D - except digit
         * \w = any alphanumeric
         * \W - except alphanumeric
         * . - any character
         * */
        String s3 = "a7b k@9";
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]]");
        Matcher m4 = p4.matcher(s3);
        System.out.println(p4 + " in " + s3);
        while (m4.find()) {
            System.out.println("s: " + m4.start() + " e: " + m4.end() + " g: " + m4.group());
        }

        // Quantifiers: used to specify number of occurrences
        /*
         * a+ - one or more of a
         * a* - zero or any number of a
         * a? - zero or one a
         * */

        Pattern p5 = Pattern.compile("a");
        Pattern p6 = Pattern.compile("a+");
        Pattern p7 = Pattern.compile("a*");
        Pattern p8 = Pattern.compile("a?");
        String s4 = "abaabaaab";
        Matcher m5 = p5.matcher(s4);
        Matcher m6 = p6.matcher(s4);
        Matcher m7 = p7.matcher(s4);
        Matcher m8 = p8.matcher(s4);
        System.out.println("\n p:" + p8 + " in " + s4 + ": l: " + s4.length());
        while (m8.find()) {
            System.out.println("s: " + m8.start() + " e: " + m8.end() + " g: " + m8.group());
        }

        // Split methods of Pattern & String class:
        // difference: string class's split method takes regex as arg
        //  Pattern's split method takes target string as arg
        // split method of pattern class
        Pattern p9 = Pattern.compile("[.]");
        String[] s9 = p9.split("www.google.com");
        System.out.println("Array of string: " + Arrays.toString(s9));

        // String class's split method

        String s5 = "this is India";
        String[] s5Ar = s5.split("\\s");
        System.out.println(Arrays.toString(s5Ar));

        // regex for mobile numbers starting with 7 8 9
        Pattern pp = Pattern.compile("[7-9][0-9]{9}");
        Matcher mm = pp.matcher("9518347599");
        while (mm.find()) {
            System.out.println("does entire string matches: " + mm.matches());
        }

        // regex for the mobile number starting with 0
        String regex = "0?[789][0-9]{9}";

        // regex for numbers starting with 91
        String phoneRegex = "(0|91)?[7-9][0-9]{9}";

        // regex to represent email ids
        String emailRegex = "[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-z0-9]+([.][a-zA-Z]+)+";

        // regex to https://www.youtube.com/watch?v=SaKm3or8bBM
        String yavaRegex = "[a-k][0369][a-zA-Z0-9#$]*";

        // req: to represent all names start with a | A
        String nameRegex = "[aA][a-zA-Z]*";

        // ending with l | L
        String namesEndingWithL = "[a-zA-Z]*[lL]";

        // all names with a| A ends with l or L
        String namesStartAEndL = "[aA][a-zA-Z]*[lL]";

        //
    }
}
