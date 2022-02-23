public class L000011 extends Template {

    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 20}));
    }

    public int maxArea(int[] height) {
        int n = height.length;
        if (n <= 1) {
            return 0;
        }

        int left = 0, right = n - 1;
        int ans = -1;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return ans;
    }
}
