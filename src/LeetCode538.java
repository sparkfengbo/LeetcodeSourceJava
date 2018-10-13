import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 把二叉搜索树转换为累加树
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class LeetCode538 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(13);

        TreeNode result = new LeetCode538().convertBST(node);
        System.out.println(result.val);
    }

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            List<TreeNode> order = orderTree(root);

            int count = 0;
            for (int i = 0; i < order.size(); i++ ) {
                count += order.get(i).val;
                order.get(i).val = count;
            }
        }
        return root;
    }

    private List<TreeNode> orderTree(TreeNode node) {
        List<TreeNode> result = new ArrayList<>();

        if (node == null) {
            return result;
        }

        if (node.right != null) {
            result.addAll(orderTree(node.right));
        }
        result.add(node);
        if (node.left != null) {
            result.addAll(orderTree(node.left));
        }
        return result;
    }

}
