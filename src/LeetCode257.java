import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class LeetCode257 {

    public static void main(String[] args) {

        LeetCode257 l257 = new LeetCode257();


        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);

        List<String> result = l257.binaryTreePaths(root);

        System.out.println(result);



        StringBuilder sb = new StringBuilder();

        sb.append("1234567");

        System.out.println(sb.toString());

        sb.setLength(5);
        System.out.println(sb.toString());

    }

    List<String> stringList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        generateTreePaths(root, sb);
        return stringList;
    }

    /**
     * 参考了 https://blog.csdn.net/crazy1235/article/details/51474128
     * @param root
     * @param sb
     */
    private void generateTreePaths(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            stringList.add(sb.toString());
        } else {
            sb.append("->");
            generateTreePaths(root.left, sb);
            generateTreePaths(root.right, sb);
        }
        sb.setLength(len);
    }
}
