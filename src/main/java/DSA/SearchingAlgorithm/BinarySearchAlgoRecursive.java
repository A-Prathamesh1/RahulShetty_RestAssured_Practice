package DSA.SearchingAlgorithm;

public class BinarySearchAlgoRecursive {

    public static int binarySearchRecursive(int[] iAr, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (target == iAr[mid]) {
                System.out.println("Located at: " + mid);
                return mid;
            }

            if (target > iAr[mid]) {
                return binarySearchRecursive(iAr, target, mid + 1, high);
            }

            if (target < iAr[mid]) {
                return binarySearchRecursive(iAr, target, low, mid - 1);
            }
        }
        System.out.println("Did not find the element: " + target);
        return -1;
    }


    public static void main(String[] args) {
        int[] iAr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 911;
        int low = 0;
        int high = iAr.length - 1;

        int target_index = binarySearchRecursive(iAr, target, low, high);

        System.out.println("Target is at: " + target_index);
    }
}
