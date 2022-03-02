package 程序员面试金典;

public class L0507 {
    public static void main(String[] args) {
        System.out.println(16 >> 31 >> 1);
    }

    public int exchangeBits(int num) {
        //奇数位全1 -> 0101.... 表示为 0x55555555
        //偶数位全1 -> 1010.... 表示为 0xaaaaaaaa
        //ans = (提取奇数位 << 1) + (提取偶数位 >> 1)
        return (((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1));
    }


}
