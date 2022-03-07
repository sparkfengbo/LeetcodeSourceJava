import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L000049 extends Template {

    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<String>> cache = new HashMap<>();
        for (String s : strs) {
            int bit = str2Bit(s);
            if (cache.containsKey(bit)) {
                List<String> value = cache.get(bit);
                value.add(s);
                cache.put(bit, value);
            } else {
                List<String> value = new ArrayList<>();
                value.add(s);
                cache.put(bit, value);
            }
        }
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> e : cache.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }

    private int str2Bit(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans |= (1 << (c - 'a' + 1));
        }
        return ans;
    }
}
