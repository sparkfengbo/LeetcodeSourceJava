import java.util.*;

/**
 * 二叉树的中序遍历
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 *     1
 *      \
 *      2
 *     /
 *    3
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

        System.out.println(inorderTraversal(root));
    }

    /**
     * 递归版本
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            if (root.left != null) {
                result.addAll(inorderTraversal(root.left));
            }

            result.add(root.val);

            if (root.right != null) {
                result.addAll(inorderTraversal(root.right));
            }
        }
        return result;
    }

    /**
     * 迭代版本
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> nodeStack = new ArrayDeque<>();

        TreeNode node = root;

        while (node != null || !nodeStack.isEmpty()) {

            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }

            TreeNode tmp = nodeStack.pollFirst();
            if (tmp != null) {
                result.add(tmp.val);
                node = tmp.right;
            }
        }

        return result;
    }
}
