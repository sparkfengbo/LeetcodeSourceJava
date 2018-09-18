import java.util.*;

/**
 * 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class LeetCode349 {

    public static void main(String[] args) {
//
        System.out.println("");

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }


        HashSet<Integer> hashSet = new HashSet<>();

        int[] shorter, longer;

        if (nums1.length >= nums2.length ) {
            shorter = nums2;
            longer = nums1;
        } else {
            shorter = nums1;
            longer = nums2;
        }

        for (int i = 0; i < shorter.length; i++) {
            hashSet.add(shorter[i]);
        }

        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < longer.length; i++) {
            if (hashSet.contains(longer[i])) {
                resultSet.add(longer[i]);
            }
        }

        int[] result = new int[resultSet.size()];

        Iterator<Integer> iterator = resultSet.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }

        return result;
    }
}
