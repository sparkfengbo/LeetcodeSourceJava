public class LeetCode63 {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }


    /**
     * 节省空间
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles_optimize(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }

                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }
            boolean[][] visited = new boolean[m][n];
            return dfs(0, 0, m - 1, n - 1, visited, obstacleGrid);
        }

        public int dfs(int r, int c, int endR, int endC, boolean[][] visited, int[][] obstacleGrid) {
            if (r == endR && c == endC) {
                return 1;
            }

            if (r < 0 || c < 0 || r > endR || c > endC || obstacleGrid[r][c] == 1) {
                return 0;
            }

            if (visited[r][c]) {
                return 0;
            }

            int[][] dir = {{1, 0}, {0, 1}};
            visited[r][c] = true;
            int count = 0;
            for (int i = 0; i < dir.length; i++) {
                count += dfs(r + dir[i][0], c + dir[i][1], endR, endC, visited, obstacleGrid);
            }
            visited[r][c] = false;
            return count;
        }
    }


}
