
import java.util.*;

public class LeetCode40_组合总和II {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }


    static class Solution_leetcode {
        List<int[]> freq = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            for (int num : candidates) {
                int size = freq.size();
                if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                    freq.add(new int[]{num, 1});
                } else {
                    ++freq.get(size - 1)[1];
                }
            }
            dfs(0, target);
            return ans;
        }

        public void dfs(int pos, int rest) {
            if (rest == 0) {
                ans.add(new ArrayList<Integer>(sequence));
                return;
            }
            if (pos == freq.size() || rest < freq.get(pos)[0]) {
                return;
            }

            dfs(pos + 1, rest);

            int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
            for (int i = 1; i <= most; ++i) {
                sequence.add(freq.get(pos)[0]);
                dfs(pos + 1, rest - i * freq.get(pos)[0]);
            }
            for (int i = 1; i <= most; ++i) {
                sequence.remove(sequence.size() - 1);
            }
        }
    }

    /**
     * https://leetcode-cn.com/problems/combination-sum-ii/solution/di-40ti-ti-jie-hui-su-suan-fa-zu-he-zong-v90r/
     */
    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(candidates, target, 0, 0);
            return ans;
        }

        private void backtrack(int[] candidates, int target, int sum, int startIndex) {
            if (sum == target) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
                //used[i - 1] == true ,说明同一树枝candidate[i - 1] 使用过
                //used[i - 1] == false; 说明同一树层candidate[i - 1] 使用过
                //对同一树层使用过的元素进行跳过
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                sum += candidates[i];
                path.add(candidates[i]);
                backtrack(candidates, target, sum, i + 1);//和39题的区别，这里是i+1，每个数字在每个组合中只能使用一次
                sum -= candidates[i];
                path.remove(path.size() - 1);
            }
        }
    }

}
