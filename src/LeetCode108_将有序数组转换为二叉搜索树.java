import datastruct.TreeNode;

import java.util.Arrays;

/**
 * 将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class LeetCode108_将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        TreeNode result = sortedArrayToBST(new int[]{-10,-3,0,5,9});

        System.out.println();

    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int n = nums.length - 1;
            return myBuildTree(nums, 0, n);
        }

        private TreeNode myBuildTree(int[] nums, int left, int right) {
            int length = right - left + 1;
            if (length <= 0) {
                return null;
            } else if (length == 1) {
                return new TreeNode(nums[left]);
            }

            int mid = (left + right) /2 ;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = myBuildTree(nums, left, mid - 1);
            root.right = myBuildTree(nums, mid + 1, right);
            return root;
        }
    }

    public static  TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int parent = nums.length / 2;
        TreeNode root = new TreeNode(nums[parent]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, parent));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, parent + 1, nums.length));
        return root;
    }
}
