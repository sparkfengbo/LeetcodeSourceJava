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
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
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
//        System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        int leftLength = Arrays.binarySearch(inorder, rootValue);
        int rightLength = inorder.length - leftLength - 1;


        int[] leftInorder = Arrays.copyOf(inorder, leftLength);
        int[] leftPostorder = Arrays.copyOf(postorder, leftLength);


        if (leftLength == 1) {
            TreeNode left = new TreeNode(leftInorder[0]);
            root.left = left;
        } else {
            root.left = buildTree(leftInorder, leftPostorder);
        }

        int[] rightInorder = Arrays.copyOfRange(inorder, leftLength + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftLength, leftLength + rightLength);

        if (rightLength == 1) {
            TreeNode left = new TreeNode(rightInorder[0]);
            root.left = left;
        } else {
            root.left = buildTree(rightInorder, rightPostorder);
        }
        return root;
    }


}
