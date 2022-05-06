package 剑指Offer;

import datastruct.ListNode;
import datastruct.TreeNode;

public class Offer07 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return myBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode myBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            int inRootIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == preorder[preStart]) {
                    inRootIndex = i;
                    break;
                }
            }
            int leftChildLength = inRootIndex - inStart;
            TreeNode root = new TreeNode(preorder[preStart]);
            root.left = myBuildTree(preorder, preStart + 1, preStart + leftChildLength, inorder, inStart, inRootIndex - 1);
            root.right = myBuildTree(preorder, preStart + leftChildLength + 1, preEnd, inorder, inRootIndex + 1, inEnd);
            return root;
        }
    }
}
