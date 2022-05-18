package 剑指Offer;

import datastruct.TreeNode;

import java.util.*;

public class Offer32_I {

    public static void main(String[] args) {

    }
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left );
                    }
                    if (node.right != null) {
                        queue.offer(node.right );
                    }
                }
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }

}
