import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utils.printNestList;

public class LeetCode16_最接近的三数之和 {

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 保证和上一次枚举的元素不相等
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int second = first + 1, third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
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
                    int k = third - 1;
                    // 移动到下一个不相等的元素
                    while (second < k && nums[k] == nums[third]) {
                        --k;
                    }
                    third = k;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int k = second + 1;
                    // 移动到下一个不相等的元素
                    while (k < third && nums[k] == nums[second]) {
                        ++k;
                    }
                    second = k;
                }
            }
        }
        return best;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int ans = 10000000;
        int n = nums.length;

        Arrays.sort(nums);

        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            int c = n - 1;
            int b = a + 1;
//            for (int second = a + 1; second < n; second++) {
            while (b < c) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                if (b == c) {
                    break;
                }
                int sum = nums[a] + nums[b] + nums[c];

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
                    int k0 = c - 1;
                    // 移动到下一个不相等的元素
                    while (b < k0 && nums[k0] == nums[c]) {
                        --k0;
                    }
                    c = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = b + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < c && nums[j0] == nums[b]) {
                        ++j0;
                    }
                    b = j0;
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
