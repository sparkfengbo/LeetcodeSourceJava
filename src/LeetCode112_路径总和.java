import datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode112_路径总和 {

    public static void main(String[] args) {


    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            if (root.val == targetSum && root.left == null && root.right == null) {
                return true;
            }

            int target = targetSum - root.val;

            return hasPathSum(root.left, target) || hasPathSum(root.right, target);

        }
    }

}
