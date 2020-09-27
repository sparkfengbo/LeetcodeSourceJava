import utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode242 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {

    }
}
