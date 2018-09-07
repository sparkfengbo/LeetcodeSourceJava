import java.util.Arrays;

/**
 * 非递减数列
 */
public class LeetCode665 {

    public static void main(String[] args) {
        //false
//        System.out.println(checkPossibility(new int[]{4, 2, 1}));
//
//        //true
//        System.out.println(checkPossibility(new int[]{4, 2, 3}));
//
//        //true
//        System.out.println(checkPossibility(new int[]{-1, 4, 2, 3}));
//
//        //false
//        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
//
//        //false
//        System.out.println(checkPossibility(new int[]{1, 5, 4, 6, 7, 10, 8, 9}));
//
//        //false
//        System.out.println(checkPossibility(new int[]{1,3,5,2,4}));

        System.out.println(checkPossibility(new int[]{1,5,4,6,7,8,9}));
    }

    public static boolean checkPossibility(int[] nums) {

        /**
         * 思想类似于二分查找，如果有多余1次需要修改，那么就是false
         */

        return check(nums, 0, nums.length) <= 1 ? true : false;
    }

    private static int check(int[] nums, int start, int end) {
        int length = end - start;

        int modCount = 0;

        if (length <=0) {
            return 0;
        } else if (length == 1) {
            return 0;
        } else if (length == 2) {
            if (nums[start] > nums[start + 1]) {
                modCount++;
            }
            return modCount;
        } else if (length == 3) {
            if (nums[start] > nums[start+1] ) {
                nums[start] = nums[start+1];
                System.out.println(Arrays.toString(nums));
                modCount++;
            }
            if (nums[start+1] > nums[start+2]) {
                nums[start+1] = nums[start+2];
                modCount++;
            }
            return modCount;
        } else {
            int mid = start + length / 2;
            int preMid = mid - 1;

            if (nums[preMid] > nums[mid]) {
                nums[preMid] = nums[mid];
                modCount++;

                //提前结束
                if (modCount > 1) {
                    return modCount;
                }
            }

            modCount += check(nums, start, mid);

            if (modCount > 1) {
                return modCount;
            }

            modCount += check(nums, mid, nums.length);

            if (modCount > 1) {
                return modCount;
            }

            if (nums[preMid] > nums[mid]) {
                nums[preMid] = nums[mid];
                modCount++;
                //提前结束
                if (modCount > 1) {
                    return modCount;
                }
            }


        }

        System.out.println(Arrays.toString(nums));
        return modCount;
    }


}
