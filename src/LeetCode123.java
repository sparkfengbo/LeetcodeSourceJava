import org.omg.CosNaming.BindingIterator;

public class LeetCode123 {

    public static void main(String[] args) {
        // 6
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));

        //4
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));

        //0
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
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
     *          dp[1][0]
     *          dp[1][1]
     *
     * 附加条件的状态转移方程：
     *          最多可以完成 两笔 交易。
     *
     *          j = [0:2] 表示当前买入次数
     *          dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + s[i]);
     *                      前一天持有cash，所以没有发生买入行为        前一天股票，当天卖出，发生了交易行为
     *
     *          dp[i][j][1] = Math.max(dp[i-1][j-1][0] - s[i], dp[i-1][j][1])
     *                      前一天持有股票，所以没有发生买入行为        前一天cash，当天买入，发生了交易行为
     *
     *          边界条件
     *
     *             j = 0   any dp = 0
     *
     *           dp[0][0:2][0] = 0
     *           dp[0][0:2][1] = -s[0]
     *

     *
     * @param prices
     * @return
     */
    //执行用时： 120 ms , 在所有 Java 提交中击败了 10.25% 的用户
    //内存消耗： 66.5 MB , 在所有 Java 提交中击败了 7.40% 的用户
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][][] dp = new int[n][3][2];

        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0] - prices[i], dp[i-1][j][1]);
            }
        }
        return dp[n-1][2][0];
    }
}
