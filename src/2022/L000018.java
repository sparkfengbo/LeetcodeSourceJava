import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L000018 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public  List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int forth = n - 1;
                int subTarget = target - nums[first] - nums[second];
                for (int third = second + 1; third < n; ++third) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }

                    while (third < forth && nums[third] + nums[forth] > subTarget) {
                        forth--;
                    }

                    if (third == forth) {
                        break;
                    }

                    if (nums[third] + nums[forth] == subTarget) {
                        List<Integer> r = new ArrayList<>();
                        r.add(nums[first]);
                        r.add(nums[second]);
                        r.add(nums[third]);
                        r.add(nums[forth]);
                        ans.add(r);
                    }
                }
            }
        }
        return ans;
    }
}
