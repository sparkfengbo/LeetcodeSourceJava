import datastruct.TreeNode;

/**
 * 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class LeetCode104 {

    public static void main(String[] args) {
        TreeNode result = new TreeNode(3);
        result.left = new TreeNode(9);

        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        result.right = right;
        System.out.println(maxDepth(result));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxD = 1;
        int maxLeft = 0, maxRight = 0;
        if (root.left != null) {
            maxLeft = maxDepth(root.left);
        }

        if (root.right != null) {
            maxRight = maxDepth(root.right);
        }

        return maxD + Math.max(maxLeft, maxRight);

    }
}
