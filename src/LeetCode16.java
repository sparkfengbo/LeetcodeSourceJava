import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utils.printNestList;

public class LeetCode16 {

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int ans = 10000000;
        int n = nums.length;

        Arrays.sort(nums);

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            int second = first + 1;
//            for (int second = first + 1; second < n; second++) {
            while (second < third) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                if (second == third) {
                    break;
                }
                int sum = nums[first] + nums[second] + nums[third];

                if (sum == target) {
                    return target;
                }

                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                // 根据差值的绝对值来更新答案
//                if (second < third && sum > target) {
//                    third--;
//                }

                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = third - 1;
                    // 移动到下一个不相等的元素
                    while (second < k0 && nums[k0] == nums[third]) {
                        --k0;
                    }
                    third = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = second + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < third && nums[j0] == nums[second]) {
                        ++j0;
                    }
                    second = j0;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Utils.println(threeSumClosest(new int[]{1,1,-1,-1,3
        }, -1));
        Utils.println(threeSumClosest(new int[]{1,1,-1,-1,3}, -1));
        Utils.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128
        }, 82));

        Utils.println(threeSumClosest2(new int[]{1,1,-1,-1,3
        }, -1));
        Utils.println(threeSumClosest2(new int[]{1,1,-1,-1,3}, -1));
        Utils.println(threeSumClosest2(new int[]{1,2,4,8,16,32,64,128
        }, 82));
    }
}
