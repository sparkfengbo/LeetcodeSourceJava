/**
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class LeetCode53_最大子数组和 {

    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//
//        System.out.println(maxSubArray(new int[]{-1}));


        System.out.println(MaxSubArray2(new int[]{-2,-100,1,-100,-3,-100,6,-100,-1,-100,2,-100,-100,1,-100,-5,-100,4}));

    }

    /**
     * wiki : https://en.wikipedia.org/wiki/Maximum_subarray_problem
     *
     * 复杂度 O(n)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = max > sum ? max : sum;
        }
        return max;
    }

    public static int MaxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


}
