import java.util.HashMap;
import java.util.Map;

public class LeetCode260 {

    public static void main(String[] args) {

    }


    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap();
        for (int n : nums)
            hashmap.put(n, hashmap.getOrDefault(n, 0) + 1);

        int[] output = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> item : hashmap.entrySet())
            if (item.getValue() == 1) output[idx++] = item.getKey();

        return output;
    }

}
