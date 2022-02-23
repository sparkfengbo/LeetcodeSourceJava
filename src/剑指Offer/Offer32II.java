package 剑指Offer;

import datastruct.TreeNode;

import java.util.*;

public class Offer32II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        Deque<TreeNode> current = new ArrayDeque<>(), next = new ArrayDeque<>();
        current.add(root);

        while (!current.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!current.isEmpty()) {
                TreeNode node = current.pollFirst();
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
                level.add(node.val);
            }
            ans.add(level);
            Deque tmpDeque = current;
            current = next;
            next = tmpDeque;
        }

        return ans;
    }

    public static void main(String[] args) {

    }


}
