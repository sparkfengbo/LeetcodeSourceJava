public class LeetCode27 {

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
}
