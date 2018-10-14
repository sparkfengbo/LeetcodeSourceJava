import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 叶子相似的树
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *          3
 *
 *
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *
 *
 * 提示：
 *
 * 给定的两颗树可能会有 1 到 100 个结点。
 */
public class LeetCode872 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        LeetCode872 leetCode872 = new LeetCode872();
        System.out.println(leetCode872.leafSimilar(root1, root2));
    }

    private List<TreeNode> preOrderLeaf(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root);
            return result;
        }

        result.addAll(preOrderLeaf(root.left));
        result.addAll(preOrderLeaf(root.right));

        return result;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        List<TreeNode> leafQueue1 = preOrderLeaf(root1);
        List<TreeNode> leafQueue2 = preOrderLeaf(root2);

        if (leafQueue1.size() != leafQueue2.size()) {
            return false;
        }

        for (int i = 0; i < leafQueue1.size(); i++) {
            if (leafQueue1.get(i).val != leafQueue2.get(i).val) {
                return false;
            }
        }
        return true;
    }

}
