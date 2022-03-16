public class LeetCode74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        if (n == 0 || matrix[m - 1][n - 1] < target) {
            return false;
        }

        int j = n - 1;
        int i = 0;

        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    //写的太复杂了
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null) {
//            return false;
//        }
//
//        int m = matrix.length;
//        if (m == 0) {
//            return false;
//        }
//        int n = matrix[0].length;
//
//        int left = 0;
//        int right = m * n - 1;
//        int pivotIndex, pivotElement;
//        while (left <= right) {
//            pivotIndex = left + (right - left) / 2;
//            pivotElement = matrix[pivotIndex / n][pivotIndex % n];
//            if (pivotElement == target) {
//                return true;
//            } else if (pivotElement < target) {
//                left = pivotIndex + 1;
//            } else {
//                right = pivotIndex - 1;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        System.out.println(searchMatrix(test, 3));

        test = new int[][]{

        };
        System.out.println(searchMatrix(test, 3));
    }
}
