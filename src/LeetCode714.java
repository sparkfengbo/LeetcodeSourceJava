
public class LeetCode714 {

    public static void main(String[] args) {
        // 8
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));

    }

    /**
     * dp[i][2]   dp[i][0] = cash, dp[i][1] = stock
     *               => target dp[n-1][0]
     * 常规的状态转移方程：
     *          dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + s[i])
     *          dp[i][1] = Max(dp[i-1][0] - s[i], dp[i-1][1])
     *
     *          dp[0][0] = 0
     *          dp[0][1] = -s[0]
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices,  int fee) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];

        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        return dp[n-1][0];
    }
}
