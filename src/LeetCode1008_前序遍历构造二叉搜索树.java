import datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1008_前序遍历构造二叉搜索树 {

    public static void main(String[] args) {
//        TreeNode result = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//        System.out.println(result.val);
//
//        TreeNode result2 = buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
//        System.out.println(result2.val);
    }
    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            int n = preorder.length;
            return muBuildTree(preorder, 0, n - 1);
        }

        private TreeNode muBuildTree(int[] preorder, int start, int end) {
            if (start > end) {
                return null;
            }
            int n = preorder.length;
            TreeNode root = new TreeNode(preorder[start]);
            int leftChildEnd = end;
            for (int i = start + 1; i < n; i++) {
                if (preorder[i] > preorder[start]) {
                    leftChildEnd = i - 1;
                    break;
                }
            }
            root.left = muBuildTree(preorder, start + 1, leftChildEnd);
            root.right = muBuildTree(preorder, leftChildEnd + 1, end);
            return root;
        }
    }

}
