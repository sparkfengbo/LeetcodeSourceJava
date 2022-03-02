package 程序员面试金典;

public class L0506 {
    public static void main(String[] args) {
        System.out.println(convertInteger(826966453, -729934991));
        System.out.println(16 >> 31 >> 1);
    }

    public static int convertInteger2(int A, int B) {
        return Integer.bitCount(A ^ B);
    }

    public static int convertInteger(int A, int B) {
        int tmp = A ^ B;
        int ans = 0;
        while (tmp != 0) {
            if ((tmp & 1) == 1) {
                ans++;
            }
            tmp >>>= 1;
        }

        return ans;
    }


    public static int convertInteger3(int A, int B) {
        int tmp = A ^ B;
        int ans = 0;
        while (tmp != 0) {
            //temp&(temp -1) 可以把temp最右边的1置0，其余位不变
            //这样，这个操作执行了几次，就是有几位要转换
            tmp = tmp & (tmp - 1);
            ans++;
        }
        return ans;
    }


}
