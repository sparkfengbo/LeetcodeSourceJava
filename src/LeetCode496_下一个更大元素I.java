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
public class LeetCode496_下一个更大元素I {

    public static void main(String[] args) {

        Solution solution = new Solution();

//        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(solution
                .nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7})));
    }

    //暴力 速度太慢
//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < nums2.length; i++) {
//            list.add(nums2[i]);
//        }
//
//        List<Integer> resultArray = new ArrayList<>();
//        for (int i = 0; i < nums1.length; i++) {
//            int index = list.indexOf(nums1[i]);
////            System.out.println(index + "  " + nums1[i]);
//
//            boolean isFind = false;
//            int j = 0;
//            if (index >= 0) {
//                for (j = index + 1; j < nums2.length; j++) {
//                    if (nums2[j] > nums1[i]) {
//                        isFind = true;
//                        break;
//                    }
//                }
//            }
//
//            if (isFind) {
//                resultArray.add(nums2[j]);
//            } else {
//                resultArray.add(-1);
//            }
//        }
//
//
//        int[] result = new int[resultArray.size()];
//
//        for (int i = 0; i < resultArray.size(); i++) {
//            result[i] = resultArray.get(i);
//        }
//
//        return result;
//    }

    class Solution_leetcode {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int i = nums2.length - 1; i >= 0; --i) {
                int num = nums2[i];
                while (!stack.isEmpty() && num >= stack.peek()) {
                    stack.pop();
                }
                map.put(num, stack.isEmpty() ? -1 : stack.peek());
                stack.push(num);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; ++i) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }

    static class Solution {

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int l = nums2.length;
            Deque<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            map.put(nums2[l - 1], -1);
            for (int i = 0; i < l - 1; i++) {
                if (nums2[i + 1] > nums2[i]) {
                    map.put(nums2[i], nums2[i + 1]);
                    while (!stack.isEmpty()) {
                        int n = stack.getLast();
                        if (n < nums2[i + 1]) {
                            map.put(n, nums2[i + 1]);
                            stack.removeLast();
                        } else {
                            break;
                        }
                    }
                } else {
                    stack.offer(nums2[i]);
                }
            }

            while (!stack.isEmpty()) {
                int n = stack.getLast();
                map.put(n, -1);
                stack.pop();
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
            }
            return res;
        }
    }


}
