public class LeetCode221 {


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 用 dp(i,j) 表示以 (i, j)(i,j) 为右下角，且只包含 1 的正方形的边长最大值。
         * 如果我们能计算出所有 dp(i,j) 的值，那么其中的最大值即为矩阵中只包含 1 的正方形的边长最大值
         * <p>
         * 如果该位置的值是  0，则  dp(i,j)=0，因为当前位置不可能在由  1 组成的正方形中；
         * <p>
         * 如果该位置的值是  1，则  dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。
         * <p>
         * 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 11，状态转移方程如下：
         * <p>
         * <p>
         * dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
         * <p>
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param matrix
         * @return
         */
        public int maximalSquare(char[][] matrix) {
            int maxSide = 0;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return maxSide;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int[][] dp = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        }
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            int maxSquare = maxSide * maxSide;
            return maxSquare;
        }
    }


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
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix));
    }
}
