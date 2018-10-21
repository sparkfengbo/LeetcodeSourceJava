import datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉搜索树的最小绝对差
 *
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 *
 * 示例 :
 *
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 *
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 注意: 树中至少有2个节点。
 */
public class LeetCode530 {

    public static void main(String[] args) {
        TreeNode result = new TreeNode(1);
        result.right = new TreeNode(3);
        result.right.left = new TreeNode(2);

        LeetCode530 leetCode530 = new LeetCode530();

        System.out.println(leetCode530.getMinimumDifference(result));

    }

    /**
     * 和 783 的阶梯方法一样
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> inOder = inOrderIter(root);
        int min = Integer.MAX_VALUE;
        int start = inOder.get(0);
        for (int i = 1; i < inOder.size(); i++) {
            int diff = inOder.get(i) - start;
            min = Math.min(diff, Math.abs(min));
            start = inOder.get(i);
        }

        return min;
    }

    public List<Integer> inOrderIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> nodeStack = new ArrayDeque<>();

        TreeNode node = root;

        while (node != null || !nodeStack.isEmpty()) {

            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }

            TreeNode tmp = nodeStack.pollFirst();
            if (tmp != null) {
                result.add(tmp.val);
                node = tmp.right;
            }
        }

        return result;
    }
}
