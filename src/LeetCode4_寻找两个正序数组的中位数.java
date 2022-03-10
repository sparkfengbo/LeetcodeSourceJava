/**
 * 两个排序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * <p>
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 解题思路： https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/
 */
public class LeetCode4_寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }


    /**
     * 思路： 归并排序
     *
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
            return (nums[length / 2] + nums[length / 2 - 1]) / 2.0f;
        } else {
            return nums[length / 2];
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, index = 0;
        while (i < left.length && j < right.length) {
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


    /**
     * 二分 每次排除 k/2
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int totalCount = m + n;
        if (totalCount % 2 == 1) {
            return findKth(nums1, nums2, totalCount / 2 + 1);
        } else {
            return (findKth(nums1, nums2, totalCount / 2) +
                    findKth(nums1, nums2, totalCount / 2 + 1)) / 2.0;
        }
    }

    public static int findKth(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;

        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }

            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
