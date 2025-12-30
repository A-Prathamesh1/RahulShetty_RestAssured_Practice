package DSA.ArraysDemo;

public class FindTheMinMax {
    public static void main(String[] args) {
        int[] iAr = new int[10];
        for (int i = 0; i < iAr.length; i++) {
            iAr[i] = (int) (Math.random() * 10);
            System.out.print(iAr[i] + ", ");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < iAr.length; i++) {
            if (iAr[i] < min) {
                min = iAr[i];
            }
            if (iAr[i] > max) {
                max = iAr[i];
            }
        }
        System.out.println("min: " + min + " , max: " + max);
    }
}
