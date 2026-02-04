package WrapperClasses;

public class WrapperClassesDemo {
    public static void main(String[] args) {
        Integer i = 10;
        Float f = 12.10f;
        Double d = 12.1;
        Character ch = 'x';
        Byte b = 12;
        Short s = 12;
        Boolean bl = false;

        // Utility Methods
        // valueOf: used to convert the primitive values into Wrapper Object
        // valueOf("string value")
        Integer i1 = Integer.valueOf("11");
        System.out.println("i1: " + i1);

        //  valueOf(String s, int radix)
        Integer i2 = Integer.valueOf("1111", 10);
        System.out.println("Binary: " + i2);

        // valueOf(primitive p)
        Integer i3 = Integer.valueOf(10);
        System.out.println(i3);

        /* byteValue(), shortValue(), intValue(), longValue(), doubleValue(),
        every Wrapper class contains these methods
        Wrapper object to primitive
        */

        Integer I = 10;
        System.out.println("byte value: " + I.byteValue());
        System.out.println("short value: " + I.shortValue());
        System.out.println("int value: " + I.intValue());
        System.out.println("float value: " + I.floatValue());
        System.out.println("long value: " + I.longValue());
        System.out.println("Double value: " + I.doubleValue());

        /*
         * To obtain primitive char value from Wrapper Character  Object
         *
         * */
        Character ch1 = 'c';
        char ch2 = ch1.charValue();
        System.out.println("char value: " + ch2);

        Boolean b1 = true;
        boolean b2 = b1.booleanValue();
        System.out.println("boolean value: " + b2);

        // parseXXX(): To obtain primitive from String
        String s1 = "1234";
        int i8 = Integer.parseInt(s1);
        System.out.println("parsing int from " + s1 + " : " + i8);

        // Integer.parseInt(String s, radix r)
        int i9 = Integer.parseInt("1010", 2);
        System.out.println("binary number parsed: " + i9);

        /*
         * toString(): convert wrapper object or primitive to String object
         * */

        // wrapper object to string
        Integer i10 = 11;
        String s10 = Integer.toString(i10);
        System.out.println("string of " + i10 + " : " + s10);

        // primitive to string
        String s9 = Integer.toString(10);

        // primitive to radix based string
        String bin = Integer.toString(10, 2);
        System.out.println("binary of 10: " + bin);

        // standard radix
        bin = Integer.toBinaryString(10);
        System.out.println(bin + " is bin of 10");

        System.out.println("hex of 10: " + Integer.toHexString(10));
        System.out.println("octal of 10: " + Integer.toOctalString(10));


        // string to wrapper obj, String -> xxx.valueOf()
        String s11 = "1111";
        Integer i11 = Integer.valueOf(s11);
        System.out.println("Integer of 1111: " + i11);

        // autoboxing & auto unboxing

    }
}
