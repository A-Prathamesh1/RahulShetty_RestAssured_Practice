package StringsDemo;

public class StringDemo {
    public static void main(String[] args) {
        String s = new String("cat"); // in heap
        String s1 = "cat";
        System.out.println(s.equals(s1));
        System.out.println(s == s1);
        System.out.println("cat" == "cat");
        System.out.println("cat".equals("cat"));
        System.out.println(12 == 'c');

        String pooled_s = s.intern(); // in pool
        System.out.println(s.equals(pooled_s));
        System.out.println(s1.equals(pooled_s)); // basically same string

//        ?? Immutability
        String a = "dog";
        String b = "dog";
        System.out.println("a.equals(b) : " + a.equals(b));
        a = a.concat(" barks!");

        System.out.println("after concat a.equals(b): " + a.equals(b));
        String s3 = new String("cat");
        String s4 = new String("cat");
        System.out.println(s3.equals(s4)); // true: equals compares the contents/values
        System.out.println(s3 == s4); // false: references will be compared, in case of primitives values will be compared
//        Object;
//        String;
//        Integer;
//        StringBuilder > mutable strings, not threadsafe
//        StringBuffer > mutable strings, thread safe

        StringBuilder sb = new StringBuilder("cat");
        StringBuilder sb1 = new StringBuilder("cat");
//        System.out.println(sb.equals(sb1)); // false
//        System.out.println(sb == sb1); // heap memory new objects
        // changes the string
        sb.append(" mewos");
        System.out.println(sb); //stringBuilder objects are mutable

        String s5 = "dog";
//      String s6 = "dog";
        s5.concat(" barks");
        System.out.println(s5); // dog: String objects are not mutable

        StringBuffer sf = new StringBuffer("cat");
        sf.append(" meows");
        System.out.println(sf); // cat meows: mutable sbf




    }
}
