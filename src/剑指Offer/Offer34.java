package 剑指Offer;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) {
                return result;
            }
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            dfs(root, target - root.val, path);
            return result;
        }

        private void dfs(TreeNode root, int target, List<Integer> path) {
            if (target == 0) {
                if (root.left == null && root.right == null) {
                    result.add(new ArrayList<>(path));
                    return;
                }
            }

            if (root.left != null) {
                path.add(root.left.val);
                dfs(root.left, target - root.left.val, path);
                path.remove(path.size() - 1);
            }

            if (root.right != null) {
                path.add(root.right.val);
                dfs(root.right, target - root.right.val, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
    }
}
