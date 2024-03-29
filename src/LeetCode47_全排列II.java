import datastruct.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47_全排列II {
    public static void main(String[] args) {
//        List<List<Integer>> res = permute(new int[]{1, 2, 3});
//        System.out.println(res);

//        List<List<Integer>> res = dfsPermute(new int[]{1, 1, 1, 2});
//        System.out.println(res);
    }
//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        ListNode
//
//    }

    class Solution {
        List ans = new ArrayList();

        public List<List<Integer>> permuteUnique(int[] nums) {
            boolean[] vis = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(new ArrayList<>(), vis, nums);
            return ans;
        }

        private void dfs(List<Integer> path, boolean[] vis, int[] nums) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (vis[i]) {
                    continue;
                }


                //当前值用过了 或
                //当前值等于前一个值： 两种情况：
                //1 nums[i-1] 没用过 说明回溯到了同一层 此时接着用num[i] 则会与 同层用num[i-1] 重复
                //2 nums[i-1] 用过了 说明此时在num[i-1]的下一层 相等不会重复
                if (i > 0 && vis[i - 1] && nums[i - 1] == nums[i]) {
                    continue;
                }

                path.add(nums[i]);
                vis[i] = true;
                dfs(path, vis, nums);
                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }
    }


}
