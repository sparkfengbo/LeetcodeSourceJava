import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode216_组合总和III {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum3(3, 7));
        System.out.println(solution.combinationSum3(3, 20));
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/combination-sum-iii/solution/zu-he-zong-he-iii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution_leetcode {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(1, 9, k, n);
            return ans;
        }

        public void dfs(int cur, int n, int k, int sum) {
            if (temp.size() + (n - cur + 1) < k || temp.size() > k) {
                return;
            }
            if (temp.size() == k) {
                int tempSum = 0;
                for (int num : temp) {
                    tempSum += num;
                }
                if (tempSum == sum) {
                    ans.add(new ArrayList<Integer>(temp));
                    return;
                }
            }
            temp.add(cur);
            dfs(cur + 1, n, k, sum);
            temp.remove(temp.size() - 1);
            dfs(cur + 1, n, k, sum);
        }
    }


    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            ans.clear();
            path.clear();
            dfs(ans, 0, 0, k, n);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, int level, int startIndex, int k, int target) {
            if (level == k && target == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }

            //防止 level 会超过K
            if (level >= k) {
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
