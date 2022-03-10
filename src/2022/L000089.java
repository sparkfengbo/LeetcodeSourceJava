import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L000089 extends Template {

    public static void main(String[] args) {


    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);

        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) ^ head);
            }

            head <<= 1;
        }

        return res;
    }
}
