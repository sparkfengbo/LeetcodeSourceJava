import datastruct.Node;

import java.util.*;

/**
 * N叉树的层序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class LeetCode429 {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Deque<Node> deque = new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Node node = deque.poll();
                    level.add(node.val);
                    for (Node n : node.children) {
                        deque.offer(n);
                    }
                }
                res.add(level);
            }
            return res;
        }
    }
}
