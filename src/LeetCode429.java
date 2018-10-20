import datastruct.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class LeetCode429 {

    public static void main(String[] args) {
        Node result = new Node(1, new ArrayList<>());

        Node left1 = new Node(3, new ArrayList<>());
        left1.children.add(new Node(5, null));
        left1.children.add(new Node(6, null));

        result.children.add(left1);
        result.children.add(new Node(2, null));
        result.children.add(new Node(4, null));
        System.out.println(levelOrder(result));

    }

    public static List<List<Integer>> levelOrder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> nodeDeque = new ArrayDeque<>();
        Deque<Node> childNodeDeque = new ArrayDeque<>();

        nodeDeque.add(root);
        while (!nodeDeque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while(!nodeDeque.isEmpty()) {
                Node node = nodeDeque.poll();
                level.add(node.val);
                if (node.children != null) {
                    childNodeDeque.addAll(node.children);
                }
            }
            result.add(level);

            nodeDeque.addAll(childNodeDeque);
            childNodeDeque.clear();
        }

        return result;
    }
}
