import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L000053 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int f = 0, max = nums[0];
        for (int i = 0; i < n; i++) {
            f = Math.max(f + nums[i], nums[i]);
            max = Math.max(max, f);
        }
        return max;
    }
}
