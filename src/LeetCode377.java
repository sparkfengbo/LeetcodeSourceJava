import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode377 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum4(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    static class Solution {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
        int res = 0;

//        public List<List<Integer>> combinationSum(int[] nums, int target) {
//            dfs(nums, target);
//            return ans;
//        }

        public int combinationSum4(int[] nums, int target) {
            dfs(nums, target);
            return res;
        }

        private void dfs(int[] nums, int target) {
            if (target == 0) {
//                ans.add(new ArrayList<>(path));
                res++;
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (target - nums[i] < 0) {
                    continue;
                }
//                path.add(nums[i]);
                dfs(nums, target - nums[i]);
//                path.remove(path.size() - 1);
            }
        }
    }

}
