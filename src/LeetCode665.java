
/**
 * 非递减数列
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
