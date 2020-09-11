import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class LeetCode459 {

    public static boolean repeatedSubstringPattern(String s) {
       return  (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        Utils.println(repeatedSubstringPattern("abab"));
        Utils.println(repeatedSubstringPattern("aba"));
        Utils.println(repeatedSubstringPattern("abcabcabcabc"));
        Utils.println(repeatedSubstringPattern("ababab"));
    }
}
