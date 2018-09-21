import java.util.Arrays;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class LeetCode105 {

    public static void main(String[] args) {
        TreeNode result = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(result.val);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                Arrays.copyOfRange(inorder, 0, rootIndex)
        );


        root.right = buildTree(
                Arrays.copyOfRange(preorder, rootIndex + 1, inorder.length),
                Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length)
        );

        return root;
    }


}
