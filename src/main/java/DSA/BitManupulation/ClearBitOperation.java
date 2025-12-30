package DSA.BitManupulation;

public class ClearBitOperation {
    public static void main(String[] args) {
        int n = 5;
        int pos = 2;
        int bitMask = 1 << pos;

        // clear bit => n AND (NOT BM)
        int res = n & (~bitMask);
//        char[] chAr = .toCharArray();
        System.out.println(Integer.toBinaryString((res)));
    }
}
