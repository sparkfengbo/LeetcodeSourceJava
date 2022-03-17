import java.util.ArrayList;
import java.util.List;

public class LeetCode78_子集 {

    public static void main(String[] args) {
        Solution solution = new Solution();


        System.out.println(solution.subsets(new int[]{1,2,3}));

    }

    class Solution_dfs {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<Integer>(t));
                return;
            }
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }
    }

    class Solution_Iter {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<Integer>(t));
            }
            return ans;
        }
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            int length = nums.length;
            for (int i = length - 1; i >= 0 ; i--) {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> path = new ArrayList<>(res.get(j));
                    path.add(0, nums[i]);
                    res.add(path);
                }
            }
            return res;
        }

    }

}
