import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 求众数
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class LeetCode169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

        System.out.println(majorityElement(new int[]{1}));


    }

    /**
     * 分支算法
     *
     * 速度比hashmap更快一些
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int left = majorityElement(Arrays.copyOfRange(nums, 0, nums.length / 2));

        int right = majorityElement(Arrays.copyOfRange(nums, nums.length / 2, nums.length));


        if (left == right) {
            return left;
        } else {
            int leftC = 0, rightC = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == left) {
                    leftC ++;
                } else if (nums[i] == right) {
                    rightC ++;
                }
            }

            if (leftC >= rightC) {
                return left;
            } else {
                return right;
            }
        }
    }


    /**
     * hashmap存储， o（n）
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count;
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else {
                count = 1;
                map.put(nums[i], count);
            }

            if (count > nums.length / 2) {
                return nums[i];
            }
        }

        //结果一定会在for循环中返回
        return -1;
    }

}
