import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class LeetCode235 {

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


        LeetCode235 leetCode235 = new LeetCode235();


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


        if (root.val > p.val && root.val > q.val) {
            //第一种情况 在左子树
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }



//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-0wpw1/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode_1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> path_p = getPath(root, p);
            List<TreeNode> path_q = getPath(root, q);
            TreeNode ancestor = null;
            for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
                if (path_p.get(i) == path_q.get(i)) {
                    ancestor = path_p.get(i);
                } else {
                    break;
                }
            }
            return ancestor;
        }

        public List<TreeNode> getPath(TreeNode root, TreeNode target) {
            List<TreeNode> path = new ArrayList<TreeNode>();
            TreeNode node = root;
            while (node != target) {
                path.add(node);
                if (target.val < node.val) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            path.add(node);
            return path;
        }
    }

    class Solution_leetcode_2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancestor = root;
            while (true) {
                if (p.val < ancestor.val && q.val < ancestor.val) {
                    ancestor = ancestor.left;
                } else if (p.val > ancestor.val && q.val > ancestor.val) {
                    ancestor = ancestor.right;
                } else {
                    break;
                }
            }
            return ancestor;
        }
    }
}
