import datastruct.ListNode;

public class LeetCode26 {

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1});
        System.out.print("");
    }


    /**
     * 双指针
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int N = nums.length;

        if (N <= 1) {
            return N;
        }

        int L = 0;
        for (int R = 1; R < N; R++) {
            if (nums[R] != nums[L]) {
                L++;
                nums[L] = nums[R];
            }
        }
        return L + 1;
    }
}
