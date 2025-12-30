package DSA.ArraysDemo;

import java.util.Scanner;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        //int[][] iAr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter the number of cols: ");
        int c = sc.nextInt();
        int[][] iAr = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Enter the number for [" + i + "] " + "[" + j + "]: ");
                iAr[i][j] = sc.nextInt();
            }
        }
        System.out.println("You entered matrix: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(iAr[i][j] + " ");
                //iAr[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        System.out.println("Transpose of the matrix: ");
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                System.out.print(iAr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
