package DSA.BitManupulation;

public class UpdateBitDemo {
    public static void main(String[] args) {
        int n = 5; //0101
        int pos = 1;
        int bitMask = 1 << pos;

        //1. set the second bit of the n to 1 <=> set operation
        System.out.println(Integer.toBinaryString(bitMask | n));

        //2. set the second bit of the 7 to 0 <=> clear operation
        // n AND (~bitMask)
        System.out.println(Integer.toBinaryString(7 & (~bitMask)));
    }
}
