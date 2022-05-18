package 剑指Offer;

import datastruct.TreeNode;

import java.util.*;

public class Offer32_III {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean reverse = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if (reverse) {
                    List<Integer> newList = new ArrayList<>();
                    for (int j = list.size() - 1; j >= 0; j--) {
                        newList.add(list.get(j));
                    }
                    result.add(newList);
                } else {
                    result.add(list);
                }
                reverse = !reverse;
            }
            return result;
        }
    }


//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/cong-shang-dao-xia-da-yin-er-cha-shu-iii-c3rs/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<List<Integer>>();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
            nodeQueue.offer(root);
            boolean isOrderLeft = true;

            while (!nodeQueue.isEmpty()) {
                Deque<Integer> levelList = new LinkedList<Integer>();
                int size = nodeQueue.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode curNode = nodeQueue.poll();
                    if (isOrderLeft) {
                        levelList.offerLast(curNode.val);
                    } else {
                        levelList.offerFirst(curNode.val);
                    }
                    if (curNode.left != null) {
                        nodeQueue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        nodeQueue.offer(curNode.right);
                    }
                }
                ans.add(new LinkedList<Integer>(levelList));
                isOrderLeft = !isOrderLeft;
            }

            return ans;
        }
    }

}
