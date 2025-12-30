package DSA.ArraysDemo;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of rows: ");
        int row = sc.nextInt();
        System.out.println("Enter total number of columns: ");
        int col = sc.nextInt();

        int[][] numbers = new int[row][col];
        // input
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter element[" + i + "][" + j + "]: ");
                numbers[i][j] = sc.nextInt();
            }
        }

        System.out.println("numbers array: " + Arrays.deepToString(numbers));

        System.out.println("Enter number you want to search: ");
        int searchItem = sc.nextInt();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (searchItem == numbers[i][j]) {
                    System.out.println("element found at [" + i + "][" + j + "]: ");
                }
            }
        }
    }
}
