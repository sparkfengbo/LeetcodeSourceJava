import java.util.Arrays;

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
 *      3
 *     / \
 *    9  20
 *       / \
 *      15 7
 */
public class LeetCode106 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode result = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(result.val);

        TreeNode result2 = buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
        System.out.println(result2.val);
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
