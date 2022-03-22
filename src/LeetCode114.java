import datastruct.TreeNode;

/**
 * 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class LeetCode114 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(5);
//        treeNode1.right.left = new datastruct.TreeNode(6);
        treeNode1.right.right = new TreeNode(7);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(4);

        LeetCode114 leetCode101 = new LeetCode114();
        leetCode101.flatten(treeNode1);

        System.out.println();
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }

        if (root.left != null) {
            root.right = root.left;
            root.left = null;
        }

    }
}
