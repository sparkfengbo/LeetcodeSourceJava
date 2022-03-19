
public class LeetCode121_买卖股票的最佳时机 {

    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//
//        System.out.println(maxSubArray(new int[]{-1}));

        // 5
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));

        System.out.println(maxProfit(new int[]{3, 3}));

        // 0-
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));

    }

    class Solution {

        /**
         * 思路就是找到当前最小的，然后往后找最大值，求差
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n <= 1) {
                return 0;
            }

            int ans = 0;

            int min = prices[0];
            for (int i = 1; i < n; i++) {
                if (prices[i] <= min) {
                    min =  prices[i];
                } else {
                    ans = Math.max(ans, prices[i] - min);
                }
            }
            return ans;
        }
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int l = 0, r = l + 1;
        int ans = 0;
        while (l < len && r < len) {
            if (prices[l] > prices[r]) {
                l = r;
                r = l + 1;
            } else if (prices[l] < prices[r]) {
                ans = Math.max(ans, prices[r] - prices[l]);
                r++;
            } else {
                l++;
                r = l + 1;
            }
        }
        return ans;
    }
}
