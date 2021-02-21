import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LeetCode102_二叉树层次遍历 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        treeNode1.right.right = new TreeNode(7);


        LeetCode102_二叉树层次遍历 leetCode101 = new LeetCode102_二叉树层次遍历();
        System.out.println(leetCode101.levelOrder(treeNode1));

    }

    public List<List<Integer>> betterlevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int currentSize = queue.size();
            for (int i = 0; i < currentSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> currentLevelQueue = new ArrayDeque<>();
        currentLevelQueue.push(root);
        Deque<TreeNode> nextLevelQueue = new ArrayDeque<>();

        while (!currentLevelQueue.isEmpty()) {
            List<Integer> current = new ArrayList<>();

            while (!currentLevelQueue.isEmpty()) {
                TreeNode node = currentLevelQueue.poll();
                current.add(node.val);

                if (node.left != null) {
                    nextLevelQueue.add(node.left);
                }

                if (node.right != null) {
                    nextLevelQueue.add(node.right);
                }
            }

            currentLevelQueue = nextLevelQueue;
            nextLevelQueue = new ArrayDeque<>();;
            ans.add(current);
        }
        return ans;
    }
}
