package 剑指Offer;

import datastruct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Offer55I {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int depth = 0;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                depth++;
            }
            return depth;
        }

    }

//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/solution/er-cha-shu-de-shen-du-by-leetcode-soluti-dk8c/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_ {
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


    public static void main(String[] args) {

    }


}
