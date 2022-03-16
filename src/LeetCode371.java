import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class LeetCode371 {

    public static void main(String[] args) {

        System.out.println(intersection(new int[]{1,2,2,1}, new int[]{2,2}));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        int[] shorter, longer;
        if (nums1.length >= nums2.length ) {
            shorter = nums2;
            longer = nums1;
        } else {
            shorter = nums1;
            longer = nums2;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < shorter.length; i++) {
            if (hashMap.containsKey(shorter[i])) {
                int count = hashMap.get(shorter[i]);
                hashMap.put(shorter[i], ++count);
            } else {
                hashMap.put(shorter[i], 1);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < longer.length; i++) {
            if (hashMap.containsKey(longer[i]) && hashMap.get(longer[i]) > 0) {
                resultList.add(longer[i]);
                int count = hashMap.get(longer[i]);
                hashMap.put(longer[i], --count);
            }
        }

        int[] result = new int[resultList.size()];

        Iterator<Integer> iterator = resultList.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            result[i++] = iterator.next();
        }

        return result;
    }
}
