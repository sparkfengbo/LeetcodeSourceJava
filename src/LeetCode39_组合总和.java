import com.sun.tools.javadoc.Start;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.*;

public class LeetCode39_组合总和 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(solution.combinationSum(new int[]{2}, 1));
    }

    static class Solution_leetcode {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> combine = new ArrayList<Integer>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
            // 直接跳过
            dfs(candidates, target, ans, combine, idx + 1);
            // 选择当前数
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }
    }


    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            int left = 0, right = 0;
            int length = candidates.length;
            for (int i = length - 1; i >= 0; i--) {
                if (candidates[i] <= target) {
                    right = i;
                    break;
                }
            }
            backtrace(res, target, left, right, candidates, new ArrayList<>());
            return res;
        }

        private void backtrace(List<List<Integer>> res, int target, int start, int right, int[] candidates, List<Integer> path) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (target < 0 || start > right || candidates[start] > target) {
                return;
            }

            backtrace(res, target, start + 1, right, candidates, path);

            path.add(candidates[start]);
            backtrace(res, target - candidates[start], start, right, candidates, path);
            path.remove(path.size() - 1);

//            path.add(candidates[start]);
//            backtrace(res, target - candidates[start], start + 1, right, candidates, path);
//            path.remove(path.size() - 1);

        }
    }

}
