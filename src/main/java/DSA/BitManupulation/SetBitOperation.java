package DSA.BitManupulation;

public class SetBitOperation {
    public static void main(String[] args) {
        int n = 5;
        int pos = 1;
        int bitMask = 1 << pos;
        int newNum = bitMask | n;


        //char[] chAr = Integer.toBinaryString(bitMask | n).toCharArray();
        System.out.println(Integer.toBinaryString(newNum).toCharArray()[1]);
    }
}
