/**
 *  两个排序数组的中位数
 *
 *  给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class LeetCode4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }


    /**
     * 思路： 归并排序
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 == 0) {
            return getResult(nums2);
        } else if (length2 == 0) {
            return getResult(nums1);
        } else {
            return getResult(merge(nums1, nums2));
        }

    }

    public static double getResult(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            return  (nums[length / 2] + nums[length / 2 - 1]) / 2.0f;
        } else {
            return  nums[length / 2];
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, index = 0;
        while(i < left.length  && j < right.length) {
            if (left[i] < right[j]) {
                result[index++] = left[i++];
            } else {
                result[index++] = right[j++];
            }
        }

        //left会有剩余
        if (i < left.length) {
            for (int k = i; k < left.length; k++) {
                result[index++] = left[k];
            }
        } else {
            for (int k = j; k < right.length; k++) {
                result[index++] = right[k];
            }
        }

        return result;
    }
}
