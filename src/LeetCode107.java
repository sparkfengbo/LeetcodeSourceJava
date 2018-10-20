import datastruct.TreeNode;

import java.util.*;

/**
 * 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class LeetCode107 {

    public static void main(String[] args) {
        LeetCode107 leetCode107 = new LeetCode107();

//        datastruct.TreeNode root = new datastruct.TreeNode(3);
//        root.left = new datastruct.TreeNode(9);
//        root.right = new datastruct.TreeNode(20);
//        root.right.left = new datastruct.TreeNode(15);
//        root.right.right = new datastruct.TreeNode(7);
//        System.out.println(leetCode107.levelOrderBottom(root));



        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        System.out.println(leetCode107.levelOrderBottom(root1));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        //根
        List<Integer> floorRoot = new ArrayList<>();
        floorRoot.add(root.val);
        result.add(floorRoot);

        Deque<TreeNode> currentfloorStack = new ArrayDeque<>();
        Deque<TreeNode> prefloorStack = new ArrayDeque<>();
        prefloorStack.push(root);

        while (!currentfloorStack.isEmpty() || !prefloorStack.isEmpty()) {
            if (!prefloorStack.isEmpty()) {
                mergeStack(prefloorStack ,currentfloorStack,result);
            } else {
                mergeStack(currentfloorStack ,prefloorStack,result);
            }
        }
        return result;
    }

    private void mergeStack(Deque<TreeNode> currentfloorStack, Deque<TreeNode> prefloorStack, LinkedList<List<Integer>> result) {
        TreeNode tmp;
        List<Integer> currentFloor = new ArrayList<>();
        while (!currentfloorStack.isEmpty()) {
            tmp = currentfloorStack.pollFirst();

            if (tmp.left == null && tmp.right == null) {
                continue;
            }



            if (tmp.left != null) {
                prefloorStack.addLast(tmp.left);
                currentFloor.add(tmp.left.val);
            }

            if (tmp.right != null) {
                prefloorStack.addLast(tmp.right);
                currentFloor.add(tmp.right.val);
            }
        }

        if (currentFloor.size() > 0) {
            result.addFirst(currentFloor);
        }

    }

}
