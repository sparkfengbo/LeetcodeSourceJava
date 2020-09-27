import java.util.LinkedList;

public class LeetCode134 {

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int N  = gas.length;
        if (N == 0) {
            return -1;
        }

        for(int i = 0; i < N; i++) {
            if (gas[i] >= cost[i]) {
                int j = i;
                int count = 0;
                int remain = 0;
                while (remain >= 0 && count <= N) {
                    remain += (gas[j] - cost[j]);
                    j = (j + 1) % N;
                    count++;
                }
                if (count == N + 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {

        int N  = gas.length;
        int totalGas = 0;
        int currnetGas = 0;
        int startIndex = 0;

        for(int i = 0; i < N; i++) {
            totalGas += gas[i] - cost[i];
            currnetGas += gas[i] - cost[i];

            if (currnetGas < 0) {
                startIndex = i + 1;
                currnetGas = 0;
            }

        }
        return totalGas>=0 ? startIndex : -1;
    }
}
