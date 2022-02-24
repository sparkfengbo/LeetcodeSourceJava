import datastruct.ListNode;
import utils.Utils;

public class L000231 extends Template {

    public static void main(String[] args) {
    }


    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & -n) == n;
    }

}
