package JavaRegex;

import java.util.StringTokenizer;

public class JavaTokenizer {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("23-12-25", "-");
        // default regex to split into tokens is space
        System.out.println("total tokens: " + st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
