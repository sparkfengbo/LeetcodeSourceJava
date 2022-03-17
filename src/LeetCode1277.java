import java.util.Arrays;

public class LeetCode1277 {

    class Solution {
        public int countSquares(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            int[][] dp = new int[m][n];

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else if (matrix[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }

                    count += dp[i][j];
                }
            }
            return count;
        }
    }
}
