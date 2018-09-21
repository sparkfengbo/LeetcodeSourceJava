import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
        root.right = r1;

        System.out.println(preorderTraversal1(root).toString());
    }

    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            result.add(root.val);

            if (root.left != null) {
                result.addAll(preorderTraversal(root.left));
            }

            if (root.right != null) {
                result.addAll(preorderTraversal(root.right));
            }
        }
        return result;

    }

    /**
     * 迭代版本
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> nodeStack = new ArrayDeque<>();

        TreeNode node = root;

        while (node != null || !nodeStack.isEmpty()) {

            while (node != null) {
                nodeStack.push(node);
                result.add(node.val);
                node = node.left;
            }

            TreeNode tmp = nodeStack.pollFirst();
            if (tmp != null) {
                node = tmp.right;
            }
        }

        return result;
    }
}
