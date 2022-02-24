package 程序员面试金典;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L0104 {

    public boolean canPermutePalindrome(String s) {

        int n = s.length();
        boolean isOdd = n % 2 == 1;
        boolean ODD = true;
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Boolean value = map.get(c);
                map.put(c, !value);
            } else {
                map.put(c, ODD);
            }
        }

        int oddCount = 0;
        for (Map.Entry<Character, Boolean> e : map.entrySet()) {
            if (!isOdd) {
                if (e.getValue()) {
                    return false;
                }
            } else {
                if (e.getValue()) {
                    if (++oddCount > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean canPermutePalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;

    }
}
