import datastruct.Node;

import java.util.ArrayList;

/**
 *
 * N叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *                 1
 *              / |  \
 *            3   2   4
 *         / |
 *         5  6
 *
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
public class LeetCode559 {

    public static void main(String[] args) {
        Node result = new Node(1, new ArrayList<>());

        Node left1 = new Node(3, new ArrayList<>());
        left1.children.add(new Node(5, null));
        left1.children.add(new Node(6, null));

        result.children.add(left1);
        result.children.add(new Node(2, null));
        result.children.add(new Node(4, null));
        System.out.println(maxDepth(result));

    }

    public static int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.size() == 0) {
            return 1;
        }

        int maxDep = 1;

        for (int i = 0; i < root.children.size(); ++i) {
            int childDep = maxDepth(root.children.get(i));
            maxDep = maxDep > childDep + 1 ? maxDep : childDep + 1 ;
        }

        return maxDep;
    }
}
