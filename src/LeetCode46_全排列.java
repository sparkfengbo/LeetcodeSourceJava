import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode46_全排列 {
    public static void main(String[] args) {
//        List<List<Integer>> res = permute(new int[]{1, 2, 3});
//        System.out.println(res);

        List<List<Integer>> res = dfsPermute(new int[]{1, 2, 3});
        System.out.println(res);
    }

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            dfs(0, new boolean[nums.length], new ArrayList<>(), nums);
            return ans;
        }

        private void dfs(int index, boolean[] visited, List<Integer> path, int[] nums) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }

                path.add(nums[i]);
                visited[i] = true;
                dfs(index + 1, visited, path, nums);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }

    }

    public static List<List<Integer>> dfsPermute(int[] nums) {
        List ans = new ArrayList();
        boolean[] vis = new boolean[nums.length];
        dfs(new ArrayList<>(), vis, nums, ans);
        return ans;
    }

    public static void dfs(List<Integer> path, boolean[] vis, int[] nums, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            path.add(nums[i]);
            vis[i] = true;
            dfs(path, vis, nums, res);
            path.remove(path.size() - 1);
            vis[i] = false;
        }
    }


    //占内存，不好
//    public static List<List<Integer>> permute(int[] nums) {
//        List ans = new ArrayList();
//        if (nums.length == 1) {
//            List<Integer> list = new ArrayList<>();
//            list.add(nums[0]);
//            ans.add(list);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int[] n = new int[nums.length - 1];
//            int index = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (j == i) continue;
//                n[index ++] = nums[j];
//            }
//            List<List<Integer>> subPermute = permute(n);
//            for (List<Integer> sublist: subPermute) {
//                List<Integer> list = new ArrayList<>();
//                list.add(nums[i]);
//                list.addAll(sublist);
//                ans.add(list);
//            }
//        }
//        return ans;
//    }

}
