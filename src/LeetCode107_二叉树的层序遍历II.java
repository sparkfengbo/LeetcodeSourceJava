import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class LeetCode107_二叉树的层序遍历II {

    public static void main(String[] args) {
        LeetCode107_二叉树的层序遍历II leetCode107 = new LeetCode107_二叉树的层序遍历II();

//        datastruct.TreeNode root = new datastruct.TreeNode(3);
//        root.left = new datastruct.TreeNode(9);
//        root.right = new datastruct.TreeNode(20);
//        root.right.left = new datastruct.TreeNode(15);
//        root.right.right = new datastruct.TreeNode(7);
//        System.out.println(leetCode107.levelOrderBottom(root));
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        System.out.println(leetCode107.levelOrderBottom(root1));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levelOrder = new LinkedList<>();

        if (root == null) {
            return levelOrder;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int currentSize = queue.size();
            for (int i = 0 ;i < currentSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelOrder.add(0, level);
        }

        return levelOrder;
    }
}
