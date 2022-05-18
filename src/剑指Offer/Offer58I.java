package 剑指Offer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Offer58I {

//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/reverse-words-in-a-string/solution/fan-zhuan-zi-fu-chuan-li-de-dan-ci-by-leetcode-sol/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        public String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            // 正则匹配连续的空白字符作为分隔符分割
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            Collections.reverse(wordList);
            return String.join(" ", wordList);
        }
    }

    static class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            String[] words = split(s);
            for (int i = words.length - 1; i>= 0; i--) {
                sb.append(words[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }

        private String[] split(String s) {
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            char[] ca = s.toCharArray();
            for (int i = 0; i < ca.length; i++) {
                if (ca[i] == ' ') {
                    if (sb.length() > 0) {
                        list.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    continue;
                } else {
                    sb.append(ca[i]);
                }
            }
            if (sb.length() > 0) {
                list.add(sb.toString());
            }
            return list.toArray(new String[list.size()]);
        }
    }

    public static void main(String[] args) {

    }


}
