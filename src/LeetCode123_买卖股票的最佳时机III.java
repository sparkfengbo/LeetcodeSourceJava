import org.omg.CosNaming.BindingIterator;

public class LeetCode123_买卖股票的最佳时机III {

    public static void main(String[] args) {
        // 6
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));

        //4
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));

        //0
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int buy1 = -prices[0], sell1 = 0;
            int buy2 = -prices[0], sell2 = 0;
            for (int i = 1; i < n; ++i) {
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }
    }


    /**
     * 一天结束时，可能有持股、可能未持股、可能卖出过1次、可能卖出过2次、也可能未卖出过
     *
     * 所以定义状态转移数组dp[天数][当前是否持股][卖出的次数]
     *
     * 具体一天结束时的6种状态：
     *
     * 未持股，未卖出过股票：说明从未进行过买卖，利润为0
     * dp[i][0][0]=0
     * 未持股，卖出过1次股票：可能是今天卖出，也可能是之前卖的（昨天也未持股且卖出过）
     * dp[i][0][1]=max(dp[i-1][1][0]+prices[i],dp[i-1][0][1])
     * 未持股，卖出过2次股票:可能是今天卖出，也可能是之前卖的（昨天也未持股且卖出过）
     * dp[i][0][2]=max(dp[i-1][1][1]+prices[i],dp[i-1][0][2])
     * 持股，未卖出过股票：可能是今天买的，也可能是之前买的（昨天也持股）
     * dp[i][1][0]=max(dp[i-1][0][0]-prices[i],dp[i-1][1][0])
     * 持股，卖出过1次股票：可能是今天买的，也可能是之前买的（昨天也持股）
     * dp[i][1][1]=max(dp[i-1][0][1]-prices[i],dp[i-1][1][1])
     * 持股，卖出过2次股票：最多交易2次，这种情况不存在
     * dp[i][1][2]=float('-inf')
     *
     * 作者：marcusxu
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/tong-su-yi-dong-de-dong-tai-gui-hua-jie-fa-by-marc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution_ {
        public int maxProfitDP(int[] prices) {
            if (prices == null || prices.length <= 1) return 0;
            int[][][] dp = new int[prices.length][2][3];
            int MIN_VALUE = Integer.MIN_VALUE / 2;//因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALUE
            //初始化
            dp[0][0][0] = 0;//第一天休息
            dp[0][0][1] = dp[0][1][1] = MIN_VALUE;//不可能
            dp[0][0][2] = dp[0][1][2] = MIN_VALUE;//不可能
            dp[0][1][0] = -prices[0];//买股票
            for (int i = 1; i < prices.length; i++) {
                dp[i][0][0] = 0;
                dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
                dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
                dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
                dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
                dp[i][1][2] = MIN_VALUE;
            }
            return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
        }
    }


    /**
     * dp[i][2]   dp[i][0] = cash, dp[i][1] = stock
     * => target dp[n-1][0]
     * 常规的状态转移方程：
     * dp[i][0] = Max(dp[i-1][0], dp[i-1][1] + s[i])
     * dp[i][1] = Max(dp[i-1][0] - s[i], dp[i-1][1])
     * <p>
     * dp[0][0] = 0
     * dp[0][1] = -s[0]
     * dp[1][0]
     * dp[1][1]
     * <p>
     * 附加条件的状态转移方程：
     * 最多可以完成 两笔 交易。
     * <p>
     * j = [0:2] 表示当前买入次数
     * dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + s[i]);
     * 前一天持有cash，所以没有发生买入行为        前一天股票，当天卖出，发生了交易行为
     * <p>
     * dp[i][j][1] = Math.max(dp[i-1][j-1][0] - s[i], dp[i-1][j][1])
     * 前一天持有股票，所以没有发生买入行为        前一天cash，当天买入，发生了交易行为
     * <p>
     * 边界条件
     * <p>
     * j = 0   any dp = 0
     * <p>
     * dp[0][0:2][0] = 0
     * dp[0][0:2][1] = -s[0]
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
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
            }
        }
        return dp[n - 1][2][0];
    }
}
