import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode145_二叉树后续遍历 {

    public static void main(String[] args) {

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.right = new TreeNode(2);
        treeNode2.right.left = new TreeNode(3);

        LeetCode145_二叉树后续遍历 leetCode = new LeetCode145_二叉树后续遍历();
        System.out.println(leetCode.postorderTraversalRecurse(treeNode2).equals(leetCode.postorderTraversalIterate(treeNode2)));

    }

    class Solution_recursive {
        List<Integer> res = new ArrayList<Integer>();

        public List<Integer> postorderTraversal(TreeNode root) {
            postorder(root);
            return res;
        }

        public void postorder(TreeNode root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            res.add(root.val);
        }
    }

    class Solution_iterator {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode prev = null;
            //主要思想：
            //由于在某颗子树访问完成以后，接着就要回溯到其父节点去
            //因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                //从栈中弹出的元素，左子树一定是访问完了的
                root = stack.pop();
                //现在需要确定的是是否有右子树，或者右子树是否访问过
                //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
                //说明可以访问当前节点
                if (root.right == null || root.right == prev) {
                    res.add(root.val);
                    //更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                    prev = root;
                    root = null;
                } else {
                    //如果右子树没有被访问，那么将当前节点压栈，访问右子树
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }

    /**
     * 递归版本
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecurse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }


    /**
     * 迭代版本
     *
     * 这个题解看着感觉思路挺清晰的
     *     https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/zhuan-ti-jiang-jie-er-cha-shu-qian-zhong-hou-xu-2/
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.right;
            }

            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(result);
        return result;
    }

}
