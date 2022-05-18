package 剑指Offer;

public class Offer42 {

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {

    }


}
