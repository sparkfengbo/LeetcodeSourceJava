package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class Offer48 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            if (len == 0) {
                return 0;
            }
            //abba
            Map<Character, Integer> cache = new HashMap<>();
            int maxLength = Integer.MIN_VALUE;
            for (int l = 0, r = 0; r < len; r++) {
                if (cache.containsKey(s.charAt(r))) {
                    l =  Math.max(l, cache.get(s.charAt(r)) + 1);
                }
                cache.put(s.charAt(r), r);
                maxLength = Math.max(maxLength, r - l + 1);
            }
            return maxLength;
        }
    }


    public static void main(String[] args) {

    }


}
