public class L000027 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};

//        System.out.println(removeElement(arr));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[slow++] = nums[i];
        }
        return slow;

    }
}
