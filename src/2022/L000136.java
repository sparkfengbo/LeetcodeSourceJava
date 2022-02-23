import java.util.Arrays;

public class L000136 extends Template {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = nums[i] ^ ans;
        }
        return ans;
    }
}
