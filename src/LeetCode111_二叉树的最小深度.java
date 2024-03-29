import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class LeetCode111_二叉树的最小深度 {

    public static void main(String[] args) {


    }

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            int min_depth = Integer.MAX_VALUE;
            if (root.left != null) {
                min_depth = Math.min(minDepth(root.left), min_depth);
            }
            if (root.right != null) {
                min_depth = Math.min(minDepth(root.right), min_depth);
            }

            return min_depth + 1;
        }
    }

    class Solution_bfs {
        class QueueNode {
            TreeNode node;
            int depth;

            public QueueNode(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<QueueNode> queue = new LinkedList<QueueNode>();
            queue.offer(new QueueNode(root, 1));
            while (!queue.isEmpty()) {
                QueueNode nodeDepth = queue.poll();
                TreeNode node = nodeDepth.node;
                int depth = nodeDepth.depth;
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(new QueueNode(node.left, depth + 1));
                }
                if (node.right != null) {
                    queue.offer(new QueueNode(node.right, depth + 1));
                }
            }

            return 0;
        }
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            int left = minDepth(root.left);
            int right = minDepth(root.right);

            return left < right ? left + 1 : right + 1;
        } else if (root.left != null) {
            return  minDepth(root.left) + 1;
        } else if (root.right != null) {
            return  minDepth(root.right) + 1;
        }
        return 1;
    }

}
