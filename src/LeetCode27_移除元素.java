public class LeetCode27_移除元素 {

    public static void main(String[] args) {
        System.out.print("");
    }

    public int removeElement(int[] nums, int val) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }

        int p0, p1;
        for (p0 = -1, p1 = 0; p1 < N; p1++) {
            if (nums[p1] != val) {
                nums[++p0] = nums[p1];
            }
        }
        return p0 + 1;
    }


    public int removeElement2(int[] nums, int val) {
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
