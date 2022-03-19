
public class LeetCode122_买卖股票的最佳时机II {

    public static void main(String[] args) {
        // 7
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));

        //4
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));

        // 0-
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));

    }

    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n <= 1) {
                return 0;
            }

            int ans = 0;
            int min = prices[0] ;
            for (int i = 1; i < n; i++) {
                if (prices[i] > min) {
                    ans += prices[i] - min;
                    min = prices[i];
                } else {
                    min = prices[i];
                }
            }

            return ans;
        }
    }


    /**
     * 定义状态  dp[i][0] 表示第  i 天交易完后手里没有股票的最大利润，
     * dp[i][1] 表示第  i 天交易完后手里持有一支股票的最大利润（i 从0 开始）。
     *
     *
     *
     *
     *
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution_dp {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }

    /**
     * 贪心
     * 计算所有价格差
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int ans = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i-1]) {
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}
