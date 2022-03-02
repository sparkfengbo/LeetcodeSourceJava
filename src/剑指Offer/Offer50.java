package 剑指Offer;

import datastruct.ListNode;

import java.util.*;

public class Offer50 {

    public static char firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static char firstUniqChar2(String s) {
//        1、第一次遍历，建立状态字和访问标记，
//        状态位：未访问或多次访问清零，访问1次置1
//        访问标记：访问两次置1
//        2、再次遍历：如果状态位为1，就返回找到的字符
//        3、否则返回找到的字符。
        int status = 0, visited = 0;
        for (char c : s.toCharArray()) {
            int offset = 1 << (c - 'a');

            if ((visited & offset) != 0) {
                continue;
            }
            if ((status & offset) != 0) {
                status ^= offset;
                visited |= offset;
            } else
                status |= offset;
        }
        for (char c : s.toCharArray()) {
            int offset = 1 << (c - 'a');
            if ((status & offset) != 0) return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }


}
