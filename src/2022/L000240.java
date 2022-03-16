public class L000240 extends Template {

    public static void main(String[] args) {
//        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }



    public boolean searchMatrix(int[][] matrix, int target) {
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
}
