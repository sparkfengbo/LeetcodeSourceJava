import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static utils.Utils.printNestList;

public class LeetCode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        //nlogn
        Arrays.sort(nums);

        int left, right;
        right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;

            int target = -nums[i];
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                int tmp = nums[left] + nums[right];
                if (tmp < target) {
                    left++;
                } else if (tmp > target) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);

                    while (left < right && nums[left + 1] == nums[left])
                        left++;
                    while (left < right && nums[right - 1] == nums[right])
                        right--;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        printNestList(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        printNestList(threeSum2(new int[]{0, 0, 0, 0}));
//        printNestList(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
