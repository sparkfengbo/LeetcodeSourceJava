import datastruct.TreeNode;

import java.util.*;

public class LeetCode103 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        treeNode1.right.right = new TreeNode(7);


        LeetCode103 leetCode101 = new LeetCode103();
//        System.out.println(leetCode101.levelOrder(treeNode1));

    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean left2right = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node;
                    if (left2right) {
                        node = queue.poll();
                        list.add(node.val);
                        if (node.left != null) {
                            queue.offer(node.left);
                        }
                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                    } else {
                        node = queue.removeLast();
                        list.add(node.val);
                        if (node.right != null) {
                            queue.addFirst(node.right);
                        }
                        if (node.left != null) {
                            queue.addFirst(node.left);
                        }
                    }
                }
                res.add(list);
                left2right = !left2right;
            }
            return res;
        }
    }
}
