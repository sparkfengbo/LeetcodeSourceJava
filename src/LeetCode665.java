
/**
 * 非递减数列
 *
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 * 示例 1:
 *
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 */
public class LeetCode665 {

    public static void main(String[] args) {
        //false
        System.out.println("期望 false  结果： " + checkPossibility(new int[]{4, 2, 1}));

        //true
        System.out.println("期望 true   结果： " + checkPossibility(new int[]{4, 2, 3}));

        //true
        System.out.println("期望 true   结果： " + checkPossibility(new int[]{-1, 4, 2, 3}));

        //false
        System.out.println("期望 false  结果： " + checkPossibility(new int[]{3, 4, 2, 3}));

        //false
        System.out.println("期望 false  结果： " + checkPossibility(new int[]{1, 5, 4, 6, 7, 10, 8, 9}));

        //false
        System.out.println("期望 false  结果： " + checkPossibility(new int[]{1, 3, 5, 2, 4}));

        //true
        System.out.println("期望 true   结果： " + checkPossibility(new int[]{2, 3, 3, 2, 4}));
    }

    public static boolean checkPossibility(int[] nums) {
        /**
         * O(n)的遍历
         */
        int modCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //发现有非递减的数
            if (nums[i] > nums[i + 1]) {
                // i - 1的数 比 i + 1 小，可以赋值为 i + 1的数值
                if (((i >= 1) && nums[i - 1] <= nums[i + 1])
                        || i == 0) {
                    nums[i] = nums[i + 1];
                    modCount++;
                } else {
                    nums[i + 1] = nums[i];
                    modCount++;
                }
                if (modCount > 1) {
                    return false;
                }
            } else if (nums[i] < nums[i + 1]) {

            }
        }
        return true;
    }

    /**
     * * {总结}
     *  1、思路偏了
     *  2、自测的测试用例不够全面，有边界问题没有想到
     */
}
