import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 *     1
 *       \
 *       2
 *      /
 *     3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode144 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        r1.left = l2;
        root.left = r1;

        System.out.println(preorderTraversalIterate(root).toString());
    }

    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalRecurse(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 迭代版本
     *
     * 思路是 指针指向当前的节点，通过队列进行回溯
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalIterate(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            //把左节点全部放入栈中
            while (node != null) {
                stack.push(node);
                ans.add(node.val);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;
    }
}



