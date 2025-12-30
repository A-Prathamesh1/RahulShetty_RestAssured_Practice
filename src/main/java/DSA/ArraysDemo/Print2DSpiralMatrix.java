package DSA.ArraysDemo;

import java.util.Arrays;

public class Print2DSpiralMatrix {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row num: ");
        int r = sc.nextInt();
        System.out.println("Enter the col num: ");
        int c = sc.nextInt();*/
        int[][] i2Ar = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//                new int[r][c];
        // populate the array
        /*System.out.println("Enter the elements of 2D array: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Enter the ele for [" + i + "][" + j + "]: ");
                i2Ar[i][j] = sc.nextInt();

            }
        }*/
        System.out.println("string of array " + Arrays.deepToString(i2Ar));
        int rowStart = 0;
        int colStart = 0;
        int colEnd = i2Ar.length - 1;
        int rowEnd = i2Ar.length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // printing the upper row of spiral
            for (int col = colStart; col <= colEnd; col++) {
                System.out.print(i2Ar[rowStart][col] + ", ");
            }
            // printing the rightmost col
            rowStart++;
            for (int row = rowStart; row <= rowEnd; row++) {
                System.out.print(i2Ar[row][colEnd] + ", ");
            }
            //printing the last row
            colEnd--;
            for (int col = colEnd; col >= colStart; col--) {
                System.out.print(i2Ar[rowEnd][col] + ", ");
            }
            //printing the leftmost column
            for (int row = rowEnd; row >= rowStart; row--) {
                System.out.print(i2Ar[row][colStart] + ", ");
            }
            // moving on to print second row
            colStart++;
        }

    }
}
