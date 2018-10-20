import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode145 {

    public static void main(String[] args) {

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.right = new TreeNode(2);
        treeNode2.right.left = new TreeNode(3);

        LeetCode145 leetCode = new LeetCode145();
        System.out.println(leetCode.postorderTraversal(treeNode2).equals(leetCode.postorderTraversal2(treeNode2)));

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(postorderTraversal(root.left));
        }
        if (root.right != null){
            result.addAll(postorderTraversal(root.right));
        }
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> nodeDeque1 = new ArrayDeque<>();
        Deque<TreeNode> nodeDeque2 = new ArrayDeque<>();

        nodeDeque1.push(root);

        TreeNode node;

        while (!nodeDeque1.isEmpty()) {
            node = nodeDeque1.poll();
            nodeDeque2.push(node);

            if (node.left != null) {
                nodeDeque1.push(node.left);
            }

            if (node.right != null) {
                nodeDeque1.push(node.right);
            }
        }

        while (!nodeDeque2.isEmpty()) {
            node = nodeDeque2.poll();
            result.add(node.val);
        }

        return result;
    }

}
