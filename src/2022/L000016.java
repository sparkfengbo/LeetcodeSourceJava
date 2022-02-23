import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L000016 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 10000;

        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1;
            int third = n - 1;

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
                if (Math.abs(sum - target) < Math.abs(ans - target) ) {
                    ans = sum;
                }
                if (sum > target) {
                    int k = third - 1;
                    while (second < k && nums[k] == nums[third]) {
                        k--;
                    }
                    third = k;
                } else {
                    int k = second + 1;
                    while (k < third && nums[k] == nums[second]) {
                        k++;
                    }
                    second = k;
                }
            }
        }
        return ans;
    }
}
