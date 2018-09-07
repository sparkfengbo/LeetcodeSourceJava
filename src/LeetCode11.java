/**
 * 盛最多水的容器
 *
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class LeetCode11 {

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }


    /**
     * 方法一：暴力法
     *
     * 时间复杂度：O(n^2)
     * 计算所有 n(n-1) /2 种高度组合的面积。
     * 空间复杂度：O(1) ，使用恒定的额外空间。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }


    /**
     * 方法二：双指针法
     *
     * 这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
     *
     * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxarea
     * 来持续存储到目前为止所获得的最大面积。
     * 在每一步中，我们会找出指针所指向的两条线段形成的区域，
     * 更新 maxarea ，并将指向较短线段的指针向较长线段那端移动一步。
     *
     *
     * 时间复杂度： O(n)，一次扫描。
     *
     * 空间复杂度： O(1)，使用恒定的空间。
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

}
