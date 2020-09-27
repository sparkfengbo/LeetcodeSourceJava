import java.util.Arrays;

import static utils.Utils.print;

public class LeetCode258 {

    //https://leetcode-cn.com/problems/add-digits/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-7/
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }


    public static void main(String[] args) {
    }
}
