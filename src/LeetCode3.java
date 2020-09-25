import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 *      请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 */
public class LeetCode3 {

    public static void main(String[] args) {
        //3
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        //1
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        //3
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
        //2
        System.out.println(lengthOfLongestSubstring("abba"));
    }


    /**
     * 双指针解法，复杂度O(n)
     *
     * 思路
     *
     * a   b   c   c   d   e   e     长度 1
     *
     * i,j
     *
     * a   b   c   c   d   e   e     长度 2
     *
     * i   j
     *
     * a   b   c   c   d   e   e     长度 3
     *
     * i       j
     *
     * a   b   c   c   d   e   e     发现重复字符，i移动，j = i + 1
     *
     * i           j
     *
     * a   b   c   c   d   e   e
     *
     *             i   j
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
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


    /**
     * 暴力解法， O(n3)
     *
     * 极端测试用例会超时
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int length = s.length();

        if (length == 0) {
            return 0;
        }

        int window = length;

        for (int i = window; i > 0; i--) {
            for (int j = 0; j + i <= length; j++) {
                boolean isMaxSub = true;
                String sub = s.substring(j, j + i);

                HashSet<Character> set = new HashSet<>();
                for (int k = 0; k < sub.length(); k++) {
                    if (set.contains(sub.charAt(k))) {
                        isMaxSub = false;
                        break;
                    } else {
                        set.add(sub.charAt(k));
                    }
                }

                if (isMaxSub) {
                    return i;
                }
            }
        }

        return 1;
    }
}
