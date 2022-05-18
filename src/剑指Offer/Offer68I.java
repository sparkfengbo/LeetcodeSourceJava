package 剑指Offer;

import datastruct.TreeNode;

public class Offer68I {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }

            if (p.left == q || p.right == q ) {
                return p;
            }

            if (q.left == p || q.right == p ) {
                return q;
            }


            if (root.val > p.val && root.val > q.val) {
                //第一种情况 在左子树
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }
    }

    public static void main(String[] args) {

    }


}
