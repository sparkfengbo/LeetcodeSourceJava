import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class LeetCode136 {

    public static void main(String[] args) {
        System.out.println(singleNumber1(new int[]{2,2,1}));
    }


    /**
     * 最直接的方法，需要使用额外空间
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        LinkedList<Integer> onceInter = new LinkedList<>();
        LinkedList<Integer> twiceInter = new LinkedList<>();


        for (int i = 0; i < nums.length; i++) {
            if (!onceInter.contains(nums[i])) {
                onceInter.add(nums[i]);
            } else {
                onceInter.remove((Integer) nums[i]);
                twiceInter.add(nums[i]);
            }
        }
        return onceInter.peekFirst();
    }


    /**
     * 使用异或
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
