import java.util.*;

public class LeetCode377 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum4(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(solution.combinationSum4(new int[]{2, 1, 3}, 35));
//        System.out.println(solution.combinationSum4(new int[]{9}, 3));
    }

    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (num <= i) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }
    }


    //dfs超时
    static class Solution_dfs {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        int res = 0;
        public int combinationSum4(int[] nums, int target) {
            dfs(nums, target);
            return res;
        }

        private void dfs(int[] nums, int target) {
            if (target == 0) {
                res++;
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (target - nums[i] < 0) {
                    continue;
                }
                dfs(nums, target - nums[i]);
            }
        }
    }

}
