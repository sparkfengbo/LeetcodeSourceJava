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
public class LeetCode145_二叉树后续遍历 {

    public static void main(String[] args) {

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.right = new TreeNode(2);
        treeNode2.right.left = new TreeNode(3);

        LeetCode145_二叉树后续遍历 leetCode = new LeetCode145_二叉树后续遍历();
        System.out.println(leetCode.postorderTraversalRecurse(treeNode2).equals(leetCode.postorderTraversalIterate(treeNode2)));

    }

    /**
     * 递归版本
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecurse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }


    /**
     * 迭代版本
     *
     * 这个题解看着感觉思路挺清晰的
     *     https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/zhuan-ti-jiang-jie-er-cha-shu-qian-zhong-hou-xu-2/
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.right;
            }

            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(result);
        return result;
    }

}
