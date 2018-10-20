import datastruct.TreeNode;

import java.util.*;

/**
 * 最大二叉树
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * Example 1:
 *
 * 输入: [3,2,1,6,0,5]
 * 输入: 返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * 注意:
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 */
public class LeetCode654 {

    public static void main(String[] args) {
        LeetCode654 leetCode = new LeetCode654();

        TreeNode result = leetCode.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});

        System.out.println();

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int maxIndex = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root  = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIndex + 1, nums.length));
        return root;
    }

}
