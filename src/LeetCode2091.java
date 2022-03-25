import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode2091 {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        treeNode1.right.right = new TreeNode(7);


        LeetCode2091 leetCode101 = new LeetCode2091();
//        System.out.println(leetCode101.levelOrder(treeNode1));

    }

    class Solution {
        public int minimumDeletions(int[] nums) {
            int length = nums.length;

            if (length < 3) {
                return length;
            }

            int minIndex = 0, maxIndex = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < length; i++) {
                if (nums[i] < min) {
                    minIndex = i;
                    min = nums[i];
                }

                if (nums[i] > max) {
                    maxIndex = i;
                    max = nums[i];
                }
            }

            int left = Math.min(maxIndex, minIndex);
            int right = Math.max(maxIndex, minIndex);
            return Math.min(Math.min(right + 1, length - left), length - right + left + 1);
        }
    }
}
