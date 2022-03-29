import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113_路径总和II {

    public static void main(String[] args) {


    }

    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return res;
            }
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            dfs(root, targetSum, path);
            return res;
        }

        private void dfs(TreeNode root, int targetSum, List<Integer> path) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null && root.val == targetSum) {
                res.add(new ArrayList<>(path));
                return;
            }

            if (root.left != null) {
                path.add(root.left.val);
                dfs(root.left, targetSum - root.val, path);
                path.remove(path.size() - 1);
            }

            if (root.right != null) {
                path.add(root.right.val);
                dfs(root.right, targetSum - root.val, path);
                path.remove(path.size() - 1);
            }
        }
    }

}
