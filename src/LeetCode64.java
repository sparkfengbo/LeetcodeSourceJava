public class LeetCode64 {

    /**
     * dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
     * <p>
     * dp[0][0] = grid[0][0]
     * dp[1][0] = grid[0][0] + grid[1][0]
     * dp[0][1] = grid[0][0] + [0][1]
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(test));

        test = new int[][]{
                {1, 3, 1},
        };
        System.out.println(minPathSum(test));

        test = new int[][]{
                {1 },
                {1 },
                {4 }
        };
        System.out.println(minPathSum(test));

        test = new int[][]{
        };
        System.out.println(minPathSum(test));
    }
}
