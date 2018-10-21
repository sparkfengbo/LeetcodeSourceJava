import datastruct.TreeNode;
import sun.tools.jconsole.MaximizableInternalFrame;

import java.util.*;

/**
 * 二叉搜索树结点最小距离
 *
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 */
public class LeetCode783 {

    public static void main(String[] args) {


    }


    public int minDiffInBST(TreeNode root) {
        List<Integer> inOder = inOrderIter(root);
        int min = Integer.MAX_VALUE;
        int start = inOder.get(0);
        for (int i = 1; i < inOder.size(); i++) {
            int diff = inOder.get(i) - start;
            min = Math.min(diff, min);
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
