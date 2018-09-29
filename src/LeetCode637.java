import java.util.*;

/**
 * 二叉树的层平均值
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 */
public class LeetCode637 {

    public static void main(String[] args) {
        LeetCode637 leetCode637 = new LeetCode637();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(leetCode637.averageOfLevels(root));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (result == null) {
            return result;
        }

        //根
        result.add((double) root.val);

        Deque<TreeNode> currentfloorStack = new ArrayDeque<>();
        Deque<TreeNode> prefloorStack = new ArrayDeque<>();
        prefloorStack.push(root);

        while (!currentfloorStack.isEmpty() || !prefloorStack.isEmpty()) {
            if (!prefloorStack.isEmpty()) {
                mergeStack(prefloorStack, currentfloorStack, result);
            } else {
                mergeStack(currentfloorStack, prefloorStack, result);
            }
        }

        return result;
    }

    private void mergeStack(Deque<TreeNode> currentfloorStack, Deque<TreeNode> prefloorStack, List<Double> result) {
        TreeNode tmp;
        int count = 0;
        double sum = 0;
        while (!currentfloorStack.isEmpty()) {
            tmp = currentfloorStack.pollFirst();
            if (tmp.left != null) {
                prefloorStack.addLast(tmp.left);
                sum += tmp.left.val;
                count++;
            }

            if (tmp.right != null) {
                prefloorStack.addLast(tmp.right);
                sum += tmp.right.val;
                count++;
            }
        }

        if (count != 0) {
            result.add(sum /count);
        }
    }

}
