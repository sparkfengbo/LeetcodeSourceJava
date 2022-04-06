import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {

    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> needMap = new HashMap<Character, Integer>();
            Map<Character, Integer> windowsMap = new HashMap<Character, Integer>();
            for (char c : t.toCharArray()) {
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            int valid = 0;
            int start = 0, end = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (needMap.containsKey(c)) {
                    windowsMap.put(c, windowsMap.getOrDefault(c, 0) + 1);
                    if (windowsMap.get(c).equals(needMap.get(c))) {
                        valid++;
                    }
                }
                while (valid == needMap.size()) {
                    if (right - left < len) {
                        len = right - left;
                        start = left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if (windowsMap.containsKey(d)) {
                        if (windowsMap.get(d).equals(needMap.get(d))) {
                            valid--;
                        }
                        windowsMap.put(d, windowsMap.getOrDefault(d, 0) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }

    public static void main(String[] args) {

    }
}
