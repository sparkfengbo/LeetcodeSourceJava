import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utils.print;
import static utils.Utils.printNestList;

public class LeetCode259 {

    public static int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int tmpSum = 0;
            int left = i + 1;
            int right = len - 1;
            int tmpTarget = target - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] < tmpTarget) {
                    tmpSum += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
            ans += tmpSum;
        }
        return ans;
    }


    public static void main(String[] args) {
        print(threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}
