package 剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class Offer04 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, column = n - 1;
        while (row < m && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
