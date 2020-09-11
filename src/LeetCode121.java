
public class LeetCode121 {

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
