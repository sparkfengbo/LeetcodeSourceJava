package 剑指Offer;

import datastruct.TreeNode;

public class Offer27 {
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.left != null || root.right != null) {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                mirrorTree(root.left);
                mirrorTree(root.right);
            }
            return root;
        }
    }

    public static void main(String[] args) {

    }


}
