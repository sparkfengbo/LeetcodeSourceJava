package 剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class Offer04 {

    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;

            }
            int m = matrix.length;
            int n = matrix[0].length;

            int r = 0, c = n - 1;
            while (r < m && c >= 0) {
                if (matrix[r][c] == target) {
                    return true;
                } else if (matrix[r][c] < target) {
                    r++;
                } else {
                    c--;
                }
            }
            return false;
        }
    }

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
