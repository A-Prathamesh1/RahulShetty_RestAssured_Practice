package DSA.javaStrings;

public class StringsDemo {
    public static void main(String[] args) {
        String s = "tony";
        String s1 = "tony";
        //concat
        System.out.println(s1 + "@" + s);
        //length
        System.out.println(s + " has length: " + s.length());
        //charAt
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
        // compare strings character by character
        if (s.compareTo(s1) > 0) {
            System.out.println(s + " is greater than " + s1);
        } else if (s.compareTo(s1) < 0) {
            System.out.println(s + " is less than " + s1);
        } else {
            System.out.println(s + " & " + s1 + " are equal");
        }

        // === & equals
        System.out.println("Using == operator: ");
        System.out.println(s1 == s1); // compares references
        System.out.println("Using equals to operator: ");
        System.out.println(s1.equals(s)); // compare values

        //substring
        System.out.println("substring 0 to 2: " + s.substring(0, 2));

        // parseInt
        String s2 = "123";
        System.out.println(s2 + " parsed for int: " + Integer.parseInt(s2));

        // toString
        int n = 123;
        System.out.println(Integer.toString(n).length());

        //
    }
}
