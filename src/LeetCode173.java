import datastruct.TreeNode;

import java.util.ArrayDeque;

/**
 * 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * 注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 */
public class LeetCode173 {

    public static class BSTIterator {

        ArrayDeque<TreeNode> inOrderStack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            //只使用了O(h)的内存
            TreeNode current = root;
            while (current != null) {
                inOrderStack.push(current);
                current = current.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !inOrderStack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = inOrderStack.pollFirst();
            int result = node.val;
            node = node.right;
            while (node != null) {
                inOrderStack.push(node);
                node = node.left;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        r1.left = l2;
        root.right = r1;

        BSTIterator i = new BSTIterator(root);

        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */


}
