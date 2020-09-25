
public class LeetCode41 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

    //https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
    public static int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] <= 0 ){
                //  nums[i] > N  这种不需要处理
                nums[i] = N + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            int num = Math.abs(nums[i]);
            if (num <= N){
                int index = num - 1;
                nums[index] = -Math.abs(nums[index]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }

        return N + 1;
    }
}
