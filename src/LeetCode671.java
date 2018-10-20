import datastruct.TreeNode;

/**
 * 二叉树中第二小的节点
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class LeetCode671 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);


        LeetCode671 leetCode671 = new LeetCode671();



        System.out.println(leetCode671.findSecondMinimumValue(root));
    }

    public int findSecondMinimumValue(TreeNode root){
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * 错误的解法，理解错题意，第二小的也可能出现在 最后一层的叶子节点
     *
     *                    1
     *              1              3
     *          1       1       3   4
     *        3   1    1  1   3  8  4  8
     *       3 3 1 6  2 1
     *
     * @param root
     * @return
     */
    public int WRONG_findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int min = root.val;

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (root.left != null) {
            left = root.left.val;
        }

        if (root.right != null) {
            right = root.right.val;
        }

        if ((left < Integer.MAX_VALUE && left > min) && (right < Integer.MAX_VALUE && right > min)) {
            return left < right ? left : right;
        } else if (left < Integer.MAX_VALUE && left > min) {
            return left;
        } else if (right < Integer.MAX_VALUE && right > min) {
            return right;
        } else {
            int findLeft = findSecondMinimumValue(root.left);
            int findRight = findSecondMinimumValue(root.right);
            return findLeft < findRight ? findLeft : findRight;
        }
    }

}
