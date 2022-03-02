package 剑指Offer;

public class Offer53I {

    public int search(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans++;
            } else if (nums[i] > target) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }


}
