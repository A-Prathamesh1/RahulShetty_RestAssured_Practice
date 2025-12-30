package DSA.BitManupulation;

public class GetBitOperation {
    public static void main(String[] args) {
        int n = 5; // 0101
        int pos = 3;
        // guess the 3rd but of n
        int bitMask = 1 << pos;
        if ((bitMask & n) == 0) {
            System.out.println("Original bit was 0");
        } else {
            System.out.println("Original bit was 1");
        }
    }
}
