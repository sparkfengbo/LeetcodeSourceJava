package 程序员面试金典;

import java.util.Deque;
import java.util.LinkedList;

public class L0501 {
    public static void main(String[] args) {
        System.out.println(16 >> 32);
        System.out.println(16 >> 31 >> 1);
    }

    public int insertBits(int N, int M, int i, int j) {

        //关于 N>>j>>1 和 N>>(j+1)的问题：测试用例中有一个是j=31，对于这个用例就体现出区别了。
        //int右移，如果右移位数不超过32，那么正常，如果大于等于32，那么结果不变。
        // 因为Java设计中，对int右移n位时，为了防止移动不切实际的位数，只采用n的低5位（0~31）.
        // 所以如果j=31的话，那么N>>j>>1会正常右移32位，得到0；
        // 而N>>(j+1)即N>>32，那么会取32的低5位（全为0）作为右移的有效位，那么就还是N本身。
        int left = N >> j >> 1;
        left = left << j << 1;
        int middle = M << i;
        int right = N & ((1 << i) - 1);
        return left | middle | right;
    }
}
