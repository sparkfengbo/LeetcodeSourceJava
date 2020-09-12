public class LeetCode1227 {


    /**
     * https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
     * @param matrix
     * @return
     */
    public static int countSquares(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
        if (c == 0) return 0;

        int[][] dp = new int[r][c];

        int ans = 0;
        for (int i = 0; i < r; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }

        for (int j = 1; j < c; j++) {
            dp[0][j] = matrix[0][j];
            ans += dp[0][j];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int tmp = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    tmp = Math.min(dp[i][j - 1], tmp);
                    dp[i][j] = tmp + 1;
                    ans += dp[i][j];
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(countSquares(matrix));
    }
}
