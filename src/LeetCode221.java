public class LeetCode221 {


    public static int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
        if (c == 0) return 0;

        int[][] dp = new int[r][c];

        int ans = 0;
        for (int i = 0; i < r; i++) {
            dp[i][0] = matrix[i][0] - '0';
            ans = Math.max(ans, dp[i][0]);
        }

        for (int j = 1; j < c; j++) {
            dp[0][j] = matrix[0][j] - '0';
            ans = Math.max(ans, dp[0][j]);
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int tmp = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    tmp = Math.min(dp[i][j - 1], tmp);
                    dp[i][j] = tmp + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }
        };
        System.out.println(maximalSquare(matrix));
    }
}
