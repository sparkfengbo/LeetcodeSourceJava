
public class LeetCode309_最佳买卖股票时机含冷冻期 {

    public static void main(String[] args) {
        // 3
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));

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
     * 附加条件的状态转移方程：
     *          卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     *          冷冻时间 1天 （卖出 到买入相隔一天，但是 买入可以马上卖出）
     *
     *          dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + s[i])
     *                      i天持有现金   i-1就持有现金  或者当天卖出（i-1天一定持有股票）
     *
     *          dp[i][1] = Max(dp[i-2][0] - s[i], dp[i-1][1])
     *                      i天持有股票   i-1就持有股票  或者当天买入（最早i-2天卖的）
     *
     *          dp[0][0] = 0
     *          dp[0][1] = -s[0]
     *
     *          dp[1][0] = Max(dp[0][0], dp[0][1] + s[1])
     *          dp[1][1] = Max(dp[0][1], -s[1])
     *
     *
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];

        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-2][0] - prices[i], dp[i-1][1]);
        }
        return dp[n-1][0];
    }
}
