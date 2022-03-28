import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode98_验证二叉搜索树 {

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution_leetcode {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode node, long lower, long upper) {
            if (node == null) {
                return true;
            }
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
        }
    }

    class Solution__ {
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            double inorder = -Double.MAX_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (root.val <= inorder) {
                    return false;
                }
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    }


    class Solution {
        List<Integer> inorder = new ArrayList<>();

        public boolean isValidBST(TreeNode root) {
            inOrder(root);
            for (int i = 1; i < inorder.size(); i++) {
                if (inorder.get(i) <= inorder.get(i - 1)) {
                    return false;
                }
            }
            return true;
        }

        private void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            inorder.add(node.val);
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {


    }
}
