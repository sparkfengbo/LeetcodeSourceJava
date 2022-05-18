package 剑指Offer;

import datastruct.TreeNode;

import java.util.*;

public class Offer37 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            List<String> levelOrder = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        levelOrder.add("null");
                        continue;
                    }
                    levelOrder.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            return String.join(",", levelOrder.toArray(new String[levelOrder.size()]));
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] levelList = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(levelList[0]));
            Deque<TreeNode> queue = new LinkedList();
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (levelList[index].equals("null")) {
                        node.left = null;
                    } else {
                        node.left = new TreeNode(Integer.parseInt(levelList[index]));
                        queue.offer(node.left);
                    }
                    index++;
                    if (levelList[index].equals("null")) {
                        node.right = null;
                    } else {
                        node.right = new TreeNode(Integer.parseInt(levelList[index]));
                        queue.offer(node.right);
                    }
                    index++;
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


    public static void main(String[] args) {

    }
}
