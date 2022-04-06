import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode129_求根节点到叶节点数字之和 {

    public static void main(String[] args) {


    }

    class Solution {
        int res = 0;
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root, root.val);
            return res;
        }

        private void dfs(TreeNode node, int curr) {
            if (node == null) {
                return;
            }

            if (node.left == null && node.right == null) {
                res += curr;
                return;
            }

            if (node.left != null) {
                int sum = node.left.val + curr * 10;
                dfs(node.left, sum);
            }

            if (node.right != null) {
                int sum = node.right.val + curr * 10;
                dfs(node.right, sum);
            }
        }
    }

}
