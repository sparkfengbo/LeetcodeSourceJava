import java.util.Arrays;
import java.util.Random;

public class L000134 extends Template {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{  2, 3, 4 }, new int[]{3, 4, 3}));
        System.out.println(canCompleteCircuit(new int[]{0, 0}, new int[]{0, 0}));
    }

    public static int canCompleteCircuit (int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int left = 0;

            boolean success = true;
            int cnt = 0;
            for (int i = start; i < start + n; i++) {
                int index = i % n;
                left += gas[index];
                if ((left -= cost[index]) < 0) {
                    success = false;
                    break;
                }
                cnt++;
            }
            if (success) {
                return start;
            } else {
                start += cnt;
            }

        }
        return -1;

    }
}
