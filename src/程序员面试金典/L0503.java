package 程序员面试金典;

public class L0503 {
    public static void main(String[] args) {
        System.out.println(16 >> 32);
        System.out.println(16 >> 31 >> 1);
    }

    public int reverseBits(int num) {
//        每次维护三个变量
//        cur：当前位置为止连续1的个数，遇到0归零，遇到1加1
//        insert：在当前位置变成1，往前数连续1的最大个数，遇到0变为cur+1，遇到1加1
//        res:保存insert的最大值即可
        int cur = 0, insert = 0, res = 1;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                cur += 1;
                insert += 1;
            } else {
                insert = cur + 1;
                cur = 0;
            }
            res = Math.max(res, insert);
        }
        return res;
    }
}
