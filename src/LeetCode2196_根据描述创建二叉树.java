import apple.laf.JRSUIUtils;
import datastruct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode2196_根据描述创建二叉树 {

    public static void main(String[] args) {
//        TreeNode result = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//        System.out.println(result.val);
//
//        TreeNode result2 = buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1});
//        System.out.println(result2.val);
    }

    class Solution {
        Map<Integer, TreeNode> nodeCache = new HashMap<>();
        Map<TreeNode, Boolean> rootCache = new HashMap<>();

        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> cache = new HashMap<>();
            int m = descriptions.length;
            int n = 3;
            for (int i = 0; i < m; i++) {
                int[] des = descriptions[i];
                boolean isLeft = des[2] == 1;
                TreeNode root = findNodeFromCache(des[0]);
                if (!rootCache.containsKey(root)) {
                    rootCache.put(root, true);
                }
                TreeNode child = findNodeFromCache(des[1]);
                rootCache.put(child, false);
                if (isLeft) {
                    root.left = child;
                } else {
                    root.right = child;
                }
            }

            for (Map.Entry<TreeNode, Boolean> entry : rootCache.entrySet()) {
                if(entry.getValue()) {
                    return entry.getKey();
                }
            }

            return null;

        }

        private TreeNode findNodeFromCache(int val) {
            TreeNode node;
            if (nodeCache.containsKey(val)) {
                node = nodeCache.get(val);
            } else {
                node = new TreeNode(val);
                nodeCache.put(val, node);
            }
            return node;
        }
    }

}
