
public class LeetCode188_买卖股票的最佳时机IV {

    public static void main(String[] args) {
        // 2
//        System.out.println(maxProfit(2, new int[]{2,4,1}));
//
//        //7
//        System.out.println(maxProfit(2,new int[]{3,2,6,5,0,3}));


        System.out.println(maxProfit(1, new int[]{1,2}));
        System.out.println(maxProfit(0, new int[]{1,3}));

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
     *
     *
     *
     *
     * @param prices
     * @return
     */

    //执行是对的，但是会超出内存限制
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2 || k <= 0) {
            return 0;
        }
        int[][][] dp = new int[n][k+1][2];

//        dp[0][1][1] = -prices[0];

        for (int j = 1; j < k+1; j++) {
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k+1; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0] - prices[i], dp[i-1][j][1]);
            }
        }
        return dp[n-1][k][0];
    }
}
