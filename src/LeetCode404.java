import datastruct.TreeNode;

/**
 * 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class LeetCode404 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);



        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);
        treeNode2.left.left = new TreeNode(4);

        LeetCode404 leetCode = new LeetCode404();
        System.out.println(leetCode.sumOfLeftLeaves(treeNode1));

        System.out.println(leetCode.sumOfLeftLeaves(treeNode2));

    }


    public int sumOfLeftLeaves(TreeNode root) {
        int count = 0;

        if (root == null) {
            return count;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            count += root.left.val;
        }

        if (root.right != null) {
            count += sumOfLeftLeaves(root.right);
        }

        if (root.left != null) {
            count += sumOfLeftLeaves(root.left);
        }

        return count;
    }
}
