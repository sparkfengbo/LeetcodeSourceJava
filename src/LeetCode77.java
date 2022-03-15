import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
//        System.out.println(solution.combinationSum4(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(solution.combine(4, 2));
    }


//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return ans;
        }

        public void dfs(int cur, int n, int k) {
            // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
            if (temp.size() + (n - cur + 1) < k) {
                return;
            }
            // 记录合法的答案
            if (temp.size() == k) {
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
            // 考虑选择当前位置
            temp.add(cur);
            dfs(cur + 1, n, k);
            temp.remove(temp.size() - 1);
            // 考虑不选择当前位置
            dfs(cur + 1, n, k);
        }
    }


    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(1, 0, n, k);
            return ans;
        }

        private void dfs(int start, int level, int n, int k) {
            if (level == k) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i <= n; i++) {
                path.add(i);
                dfs(i + 1, level + 1, n, k);
                path.remove(path.size() - 1);
            }
        }
    }

}
