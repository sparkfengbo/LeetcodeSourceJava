package 剑指Offer;


public class Offer29 {

    /**
     * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
     * <p>
     * 这个解法写的更简洁
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int index = 0;
        int[] ans = new int[(r + 1) * (b + 1)];

        while (true) {
            //左右
            for (int i = l; i <= r; i++) ans[index++] = matrix[t][i];
            if (++t > b) break;
            //上下
            for (int i = t; i <= b; i++) ans[index++] = matrix[i][r];
            if (l > --r) break;
            //右左
            for (int i = r; i >= l; i--) ans[index++] = matrix[b][i];
            if (t > --b) break;
            //下上
            for (int i = b; i >= t; i--) ans[index++] = matrix[i][l];
            if (++l > r) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = (spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));

        for (int item : ans) {
            System.out.print(item);
        }
        System.out.println();
    }


}
