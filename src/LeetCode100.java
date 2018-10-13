/**
 * 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class LeetCode100 {

    public static void main(String[] args) {
//        System.out.println(isSameTree(new int[]{3}, new int[]{-2, -1}));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        }

        if (p.val == q.val) {
            boolean isLeftSame = true, isRightSame = true;
            if (p.left == null && q.left == null && p.right == null && q.right == null) {
                return true;
            }

            if ((p.left == null && q.left != null) ||
                    (p.right == null && q.right != null) ||
                    (q.left == null && p.left != null) ||
                    (q.right == null && p.right != null)) {
                return false;
            }

            if (p.left != null && q.left != null) {
                isLeftSame = isSameTree(p.left, q.left);
            }

            if (p.right != null && q.right != null) {
                isRightSame = isSameTree(p.right, q.right);
            }

            return isLeftSame && isRightSame;
        } else {
            return false;
        }
    }

}
