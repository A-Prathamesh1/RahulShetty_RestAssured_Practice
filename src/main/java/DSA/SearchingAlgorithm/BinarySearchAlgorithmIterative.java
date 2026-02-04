package DSA.SearchingAlgorithm;

public class BinarySearchAlgorithmIterative {
    public static void main(String[] args) {
        int[] iAr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 91;

        int low = 0;
        int high = iAr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (iAr[mid] == target) {
                System.out.println("target is at: " + mid);
                break;
            }

            if (target > iAr[mid]) { // then target is in the right half of the array
                // reset the low
                low = mid + 1;
            }

            if (target < iAr[mid]) { // target is in left part of the array
                // rest the high
                high = mid - 1;
            }
        }
    }
}
