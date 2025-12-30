package DSA.javaStrings.StringBuilderDemo;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Tony");
        System.out.println(sb);

        //charAt
        System.out.println("0th char of " + sb + " is " + sb.charAt(0));

        // set char at
        System.out.println("Original string: " + sb);
        sb.setCharAt(0, 't');
        System.out.println("after replacing T with t: " + sb);

        // inserting at index
        System.out.println("make " + sb + " Tonny: ");
        sb.insert(2, 'n');
        System.out.println("after: " + sb);

        // delete the char
        System.out.println("make " + sb + " tony");
        sb.delete(2, 3);
        System.out.println("after: " + sb);

        // append at the end
        System.out.println("make " + sb + ": tony stark");
        sb.append(" stark");
        System.out.println("after: " + sb);

        // reverse a StringBuilder
        System.out.println("Reversing: " + sb);
        for (int i = sb.length() - 1; i >= 0; i--) {
            System.out.print(sb.charAt(i));
        }
    }
}
