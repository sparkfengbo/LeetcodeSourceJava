import datastruct.TreeNode;

/**
 * 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class LeetCode226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        node2.left = node5;
        node2.right = node6;

        TreeNode result = invertTree(root);

        System.out.println();
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null && root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);

        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
        }
        return root;
    }
}
