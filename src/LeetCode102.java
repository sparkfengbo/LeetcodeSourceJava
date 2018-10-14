import java.util.*;

/**
 * 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LeetCode102 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        treeNode1.right.right = new TreeNode(7);


        LeetCode102 leetCode101 = new LeetCode102();
        System.out.println(leetCode101.levelOrder(treeNode1));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> preLevel = new ArrayDeque<>();
        preLevel.push(root);
        Deque<TreeNode> currentLevle = new ArrayDeque<>();

        while (!preLevel.isEmpty()) {

            List<Integer> current = new ArrayList<>();

            while (!preLevel.isEmpty()) {
                TreeNode node = preLevel.poll();
                current.add(node.val);

                if (node.left != null) {
                    currentLevle.add(node.left);
                }

                if (node.right != null) {
                    currentLevle.add(node.right);
                }
            }

            preLevel.addAll(currentLevle);
            currentLevle.clear();
            result.add(current);

        }

        return result;
    }
}
