import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utils.printNestList;

public class LeetCode18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }

            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }

                int fourth = n - 1;
                int tmpTarget = target - nums[first] - nums[second];
                for (int third = second + 1; third < n; third++) {
                    if (third > second + 1 && nums[third - 1] == nums[third]) {
                        continue;
                    }

                    while (fourth > third && nums[third] + nums[fourth] > tmpTarget) {
                        fourth--;
                    }

                    if (fourth == third) {
                        break;
                    }

                    if ( nums[third] + nums[fourth] == tmpTarget) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        printNestList(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        printNestList(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        printNestList(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
