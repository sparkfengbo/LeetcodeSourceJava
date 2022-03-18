import sun.awt.geom.AreaOp;

import java.util.*;

/**
 * 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 * <p>
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 */
public class LeetCode556_下一个更大元素III {

    public static void main(String[] args) {
        Solution solution = new Solution();

//
//        System.out.println(solution.nextGreaterElement(12));
//        System.out.println(solution.nextGreaterElement(21));
//        System.out.println(solution.nextGreaterElement(12632));
        System.out.println(solution.nextGreaterElement(Integer.MAX_VALUE));
    }


    static class Solution {
        public int nextGreaterElement(int n) {
            char[] s = getNext(String.valueOf(n).toCharArray());
            return s == null ? -1 : parseInt(s);
        }

        private int parseInt(char[] s) {
            int length = s.length;
            int res = 0;
            for (int i = 0; i < length; i++) {
                int sum = (int) ((s[i] - '0') * Math.pow(10, length - i - 1));
                res += sum;
                if (res <= 0) {
                    return -1;
                }
            }
            return res;
        }

        private char[] getNext(char[] s) {
            int length = s.length;
            int index = -1;
            for (int i = length - 1; i > 0; i--) {
                if (s[i - 1] < s[i]) {
                    index = i - 1;
                    break;
                }
            }
            if (index == -1) {
                return null;
            }

            int index2 = -1;
            for (int i = length - 1; i > index; i--) {
                if (s[i] > s[index]) {
                    index2 = i;
                    break;
                }
            }
            swap(s, index, index2);
            reverse(s, index + 1);
            return s;
        }

        private void reverse(char[] s, int i) {
            int left = i;
            int right = s.length - 1;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
        }

        private void swap(char[] s, int i, int j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
}
