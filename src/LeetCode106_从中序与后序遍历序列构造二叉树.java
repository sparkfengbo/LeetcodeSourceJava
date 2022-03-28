import datastruct.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * / \
 * 15 7
 */
public class LeetCode106_从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {
        TreeNode result = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(result.val);

        TreeNode result2 = buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
        System.out.println(result2.val);
    }

    class Solution {
        Map<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            indexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
        }

        private TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_Left, int inorder_right, int postorder_left, int postorder_right) {
            if (inorder_Left > inorder_right) {
                return null;
            }

            int postorder_root = postorder_right;

            TreeNode root = new TreeNode(postorder[postorder_root]);
            int inorder_root = indexMap.get(postorder[postorder_root]);
            int left_subtree_size = inorder_root - inorder_Left;
            root.left = myBuildTree(inorder, postorder, inorder_Left, inorder_root - 1, postorder_left, postorder_left + left_subtree_size - 1);
            root.right = myBuildTree(inorder, postorder, inorder_root + 1, inorder_right, postorder_left + left_subtree_size, postorder_right - 1);
            return root;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        } else if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        root.left = buildTree(
                Arrays.copyOfRange(inorder, 0, rootIndex),
                Arrays.copyOfRange(postorder, 0, rootIndex)
        );


        root.right = buildTree(
                Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length),
                Arrays.copyOfRange(postorder, rootIndex, inorder.length - 1)
        );

        return root;
    }


}
