import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static utils.Utils.print;

public class LeetCode266 {

    public static boolean canPermutePalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        HashMap<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.containsKey(s.charAt(i))) {
                int count = set.get(s.charAt(i));
                set.put(s.charAt(i), count + 1);
            } else {
                set.put(s.charAt(i), 1);
            }
        }

        int odd = 0;

        for (Map.Entry<Character, Integer> entry : set.entrySet()) {
            int count = entry.getValue();
            if (count % 2 == 1) {
                odd++;
                if (odd > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        print(canPermutePalindrome("code"));
        print(canPermutePalindrome("aab"));
        print(canPermutePalindrome("carerac"));
    }
}
