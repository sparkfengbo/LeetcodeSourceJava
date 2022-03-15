import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode216 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum3(3, 7));
        System.out.println(solution.combinationSum3(3, 9));
    }


    /**
     * https://leetcode-cn.com/problems/combination-sum-ii/solution/di-40ti-ti-jie-hui-su-suan-fa-zu-he-zong-v90r/
     */
    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            ans.clear();
            path.clear();
            dfs(ans, 0, 0, k, n);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, int level, int startIndex,  int k, int target) {
            if (level == k && target == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i < 9; i++) {
                if (target >= i + 1) {
                    path.add(i + 1);
                    dfs(ans, level + 1, i + 1, k, target - i - 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

}
