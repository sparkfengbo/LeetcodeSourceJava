import datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class LeetCode101 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(2);
        treeNode2.left.right = new TreeNode(3);
        treeNode2.left.left = new TreeNode(3);

        LeetCode101 leetCode101 = new LeetCode101();
        System.out.println(leetCode101.isSymmetric(treeNode1));
        System.out.println(leetCode101.isSymmetric(treeNode2));

    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null) {
            Queue<TreeNode> leftNode = new ArrayDeque<>();
            Queue<TreeNode> rightNode = new ArrayDeque<>();

            ((ArrayDeque<TreeNode>) leftNode).push(root.left);
            ((ArrayDeque<TreeNode>) rightNode).push(root.right);

            while (!leftNode.isEmpty() && !rightNode.isEmpty()) {
                TreeNode left = leftNode.poll();
                TreeNode right = rightNode.poll();

                if (left == null || right == null) {
                    return false;
                }

                if (left.val != right.val) {
                    return false;
                }

                if (left.left != null && right.right != null) {
                    ((ArrayDeque<TreeNode>) leftNode).add(left.left);
                    ((ArrayDeque<TreeNode>) rightNode).add(right.right);
                } else if ((left.left == null && right.right != null)
                        || (left.left != null && right.right == null)) {
                    return false;
                }

                if (left.right != null && right.left != null) {
                    ((ArrayDeque<TreeNode>) leftNode).add(left.right);
                    ((ArrayDeque<TreeNode>) rightNode).add(right.left);
                } else if ((left.right == null && right.left != null)
                        || (left.right != null && right.left == null)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
