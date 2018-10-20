import datastruct.TreeNode;

/**
 * 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class LeetCode543 {

    public static void main(String[] args) {

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(2);
        treeNode2.left.left = new TreeNode(3);
        treeNode2.left.right = new TreeNode(3);

        LeetCode543 leetCode101 = new LeetCode543();
        System.out.println(leetCode101.diameterOfBinaryTree(treeNode2));

    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        branchDepth(root);
        return max;
    }

    private int branchDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = branchDepth(root.left);
        int right = branchDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }



}
