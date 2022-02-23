public class L000041 extends Template {

    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{1,2,0}));
//        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 20}));
        System.out.println(firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10}));
//        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                int index = num - 1;
                nums[index] = -Math.abs(nums[index]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
