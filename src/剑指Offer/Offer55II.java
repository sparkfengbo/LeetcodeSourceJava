package 剑指Offer;

import datastruct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Offer55II {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
               return true;
            }
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }

            return isBalanced(root.left) && isBalanced(root.right);
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }



//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/solution/ping-heng-er-cha-shu-by-leetcode-solutio-6r1g/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }



    public static void main(String[] args) {

    }


}
