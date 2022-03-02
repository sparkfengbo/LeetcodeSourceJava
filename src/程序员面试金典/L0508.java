package 程序员面试金典;

public class L0508 {
    public static void main(String[] args) {
        System.out.println(16 >> 31 >> 1);
    }

    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ans = new int[length];
        int size = length * 32, left = y * w + x1, right = y * w + x2, num = 0;
        for (int i = 0; i < size; i++) {
            int power = 31 - i % 32;
            if (i >= left && i <= right)
                num += 1 << power;
            else
                num += 0 << power;
            if (i % 32 == 31) {
                ans[i / 32] = num;
                num = 0;
            }
        }
        return ans;
    }
}
