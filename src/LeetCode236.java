import datastruct.TreeNode;

import java.util.ArrayDeque;

/**
 * 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class LeetCode236 {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(6);
//        TreeNode p = new TreeNode(2);
//        root.left = p;
//        root.left.left = new TreeNode(0);
//        TreeNode q = new TreeNode(4);
//        root.left.right = q;
//        root.left.right.left = new TreeNode(3);
//        root.left.right.right = new TreeNode(5);
//
//        root.right = new TreeNode(8);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(9);


        LeetCode236 leetCode235 = new LeetCode236();


        TreeNode root = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        TreeNode p = new TreeNode(3);
        root.left = q;
        root.right = p;


        TreeNode result = leetCode235.lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (p.left == q || p.right == q ) {
            return p;
        }

        if (q.left == p || q.right == p ) {
            return q;
        }

        int directP = searchTreeNode(root, p);
        int directQ = searchTreeNode(root, q);

        if (directP == 1 && directQ == 1) {
            //第一种情况 在左子树
            return lowestCommonAncestor(root.left, p, q);
        } else if (directP == 2 && directQ == 2) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * 查找节点在 左子树 还是右字数
     * @return  1 左  2 右 3就是根节点 -1没有此节点
     */
    public int searchTreeNode(TreeNode root, TreeNode node) {
        ArrayDeque<TreeNode> left = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> right = new ArrayDeque<TreeNode>();

        if (root == node) {
           return 3;
        }

        if (root.left != null) {
            left.push(root.left);
        }

        if (root.right != null) {
            right.push(root.right);
        }

        while(!left.isEmpty()) {
            TreeNode leftNode = left.pollFirst();

            if (leftNode.val == node.val) {
                return 1;
            }

            if (leftNode.left != null) {
                left.push(leftNode.left);
            }

            if (leftNode.right != null) {
                left.push(leftNode.right);
            }
        }

        while(!right.isEmpty()) {
            TreeNode rightNode = right.pollFirst();

            if (rightNode.val == node.val) {
                return 2;
            }

            if (rightNode.left != null) {
                right.push(rightNode.left);
            }

            if (rightNode.right != null) {
                right.push(rightNode.right);
            }
        }

        return -1;
    }
}
