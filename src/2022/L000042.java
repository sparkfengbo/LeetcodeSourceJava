public class L000042 extends Template {

    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 20}));
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n <= 1) {
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}