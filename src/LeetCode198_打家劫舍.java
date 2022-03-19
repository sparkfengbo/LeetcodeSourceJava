
public class LeetCode198_打家劫舍 {

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{}));
        // 4
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        //12
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    class Solution {

        //贪心不可以
//        public int rob(int[] nums) {
//            int n = nums.length;
//            int sum1 = 0;
//            int sum2 = 0;
//
//            for (int i = 0; i < n; i++) {
//                if (i % 2 == 0) {
//                    sum1 += nums[i];
//                } else {
//                    sum2 += nums[i];
//                }
//            }
//
//            return Math.max(sum1, sum2);
//        }

        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return nums[0];
            }

            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[n - 1];
        }

    }
}
