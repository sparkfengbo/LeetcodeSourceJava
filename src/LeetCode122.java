
public class LeetCode122 {

    public static void main(String[] args) {
        // 7
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));

        //4
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));

        // 0-
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));

    }
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
