import java.util.*;

public class LeetCode377_组合总和IV {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum4(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(solution.combinationSum4(new int[]{2, 1, 3}, 35));
//        System.out.println(solution.combinationSum4(new int[]{9}, 3));
    }

    static class Solution {
        /**
         * dp[x] 表示选取的元素之和等于 x 的方案数，目标是求 dp[target]。
         * <p>
         * dp[0]=1。只有当不选取任何元素时，元素之和才为  0，因此只有  1 种方案。
         * <p>
         * 1≤i≤target 时，如果存在一种排列，其中的元素之和等于  i，则该排列的最后一个元素一定是数组 nums 中的一个元素。
         * 假设该排列的最后一个元素是  num，则一定有  num≤i，对于元素之和等于  i−num 的每一种排列，
         * 在最后添加 num 之后即可得到一个元素之和等于 ii 的排列，因此在计算  dp[i] 时，应该计算所有的  dp[i−num] 之和。
         * <p>
         * 由此可以得到动态规划的做法：
         * <p>
         * 初始化 dp[0]=1；
         * <p>
         * 遍历  i 从  1 到  target，对于每个  i，进行如下操作：
         * <p>
         * 遍历数组  nums 中的每个元素 num，当  num≤i 时，将  dp[i−num] 的值加到  dp[i]。
         * 最终得到  dp[target] 的值即为答案。
         *
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/combination-sum-iv/solution/zu-he-zong-he-iv-by-leetcode-solution-q8zv/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param nums
         * @param target
         * @return
         */
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
