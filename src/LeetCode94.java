import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉树的中序遍历
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        r1.left = l2;
        root.right = r1;

        System.out.println(inorderTraversalRecurse(root));
    }

    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalRecurse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversalRecurse(root.left));
        result.add(root.val);
        result.addAll(inorderTraversalRecurse(root.right));
        return result;
    }

    /**
     * 迭代版本
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalIterate(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode tmp = stack.pop();
            ans.add(tmp.val);
            node = tmp.right;
        }

        return ans;
    }
}
