import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 另一个树的子树
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 */
public class LeetCode572 {

    public static void main(String[] args) {

        LeetCode572 leetCode572 = new LeetCode572();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        TreeNode node = new TreeNode(1);

        System.out.println(leetCode572.isSubtree(root, node));


    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<TreeNode> sameVal = search(s, t.val);

        if (sameVal.size() == 0) {
            return false;
        }
        for (int i = 0; i < sameVal.size(); i++) {
            if (isSameTree(sameVal.get(i), t)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    public List<TreeNode> search(TreeNode root, int val) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<TreeNode> result = new ArrayList<>();

        if (root.val == val) {
            result.add(root);
        }

        result.addAll(search(root.left, val));
        result.addAll(search(root.right, val));
        return result;
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        boolean leftSame = false, rightSame = false;

        if (node1.left != null && node2.left != null) {
            leftSame = isSameTree(node1.left, node2.left);
        } else if (node1.left == null && node2.left == null) {
            leftSame = true;
        }

        if (node1.right != null && node2.right != null) {
            rightSame = isSameTree(node1.right, node2.right);
        } else if (node1.right == null && node2.right == null) {
            rightSame = true;
        }

        return leftSame && rightSame;
    }

}
