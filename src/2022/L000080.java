import netscape.security.UserTarget;

public class L000080 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};

        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int step = 2;
        if (nums.length <= step) {
            return nums.length;
        }

        int slow = step;
        for (int fast = step; fast < nums.length; fast++) {
            if (nums[slow - step] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
